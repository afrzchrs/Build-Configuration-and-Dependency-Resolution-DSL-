package dsl.visitor;

import dsl.model.*;
import dsl.executor.Executor;
import dsl.executor.DependencyDownloader;
import dsl.executor.JarPackager;
import dsl.antlr.BuildDSLBaseVisitor;
import dsl.antlr.BuildDSLParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList; 
import java.util.Comparator;
import java.util.List;     
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildVisitor extends BuildDSLBaseVisitor<Object> {

    private Project project = null;
    private String currentEnv = "dev";
    private String rootOutDir = "out"; 
    private String sourcePath = null;

    @Override
    public Object visitProject(BuildDSLParser.ProjectContext ctx) {
        String name = stripQuotes(ctx.name.getText());
        project = new Project();
        project.name = name;

        if (ctx.sourcePath != null) {
            String raw = stripQuotes(ctx.sourcePath.getText());
            this.sourcePath = raw.replace("\\", "/"); 
        }

        System.out.println(">>> [INIT] Memulai Proyek: " + name);
        
        String projectDir = rootOutDir + File.separator + name;

        deletePath(projectDir);

        createDir(projectDir);
        createDir(projectDir + File.separator + "src");
        createDir(projectDir + File.separator + "lib");
        createDir(projectDir + File.separator + "bin");

        return super.visitProject(ctx);
    }

    @Override
    public Object visitDecl(BuildDSLParser.DeclContext ctx) {
        String depString = stripQuotes(ctx.STRING(0).getText());
        String version = stripQuotes(ctx.STRING(1).getText());

        project.dependencies.add(new Dependency(depString, version));
        return null;
    }

    @Override
    public Object visitTaskDecl(BuildDSLParser.TaskDeclContext ctx) {
        Task t = new Task();
        t.name = ctx.ID().getText();

        for (int i = 0; i < ctx.taskBody().getChildCount(); i++) {
            var child = ctx.taskBody().getChild(i);
            
            if (child instanceof BuildDSLParser.OrganizeCmdContext) {
                t.commands.add("ORGANIZE");
            }
            else if (child instanceof BuildDSLParser.FixDepCmdContext) {
                t.commands.add("FIX_DEPS");
            }
            else if (child instanceof BuildDSLParser.RunCmdContext) {
                t.commands.add("RUN|" + stripQuotes(((BuildDSLParser.RunCmdContext)child).STRING().getText()));
            } 
            else if (child instanceof BuildDSLParser.EchoCmdContext) {
                t.commands.add("ECHO|" + stripQuotes(((BuildDSLParser.EchoCmdContext)child).STRING().getText()));
            }
            else if (child instanceof BuildDSLParser.MkdirCmdContext) {
                t.commands.add("MKDIR|" + stripQuotes(((BuildDSLParser.MkdirCmdContext)child).STRING().getText()));
            }
            else if (child instanceof BuildDSLParser.CopyCmdContext) {
                var c = (BuildDSLParser.CopyCmdContext) child;
                t.commands.add("COPY|" + stripQuotes(c.STRING(0).getText()) + "|" + stripQuotes(c.STRING(1).getText()));
            }
            else if (child instanceof BuildDSLParser.DeleteCmdContext) {
                t.commands.add("DELETE|" + stripQuotes(((BuildDSLParser.DeleteCmdContext)child).STRING().getText()));
            }
            else if (child instanceof BuildDSLParser.TaskCallContext) {
                t.subTasks.add(((BuildDSLParser.TaskCallContext)child).ID().getText());
            }
        }
        project.tasks.put(t.name, t);
        return null;
    }

    private String stripQuotes(String s) {
        if (s == null || s.length() < 2) return s;
        if (s.startsWith("\"") && s.endsWith("\"")) s = s.substring(1, s.length() - 1);
        return s.replace("\\\"", "\"");
    }

    @Override
    public Object visitIfDecl(BuildDSLParser.IfDeclContext ctx) {
        String targetEnv = stripQuotes(ctx.STRING().getText());
        if (currentEnv.equals(targetEnv)) {
            for (int i = 0; i < ctx.getChildCount(); i++) {
                var child = ctx.getChild(i);
                if (!(child instanceof TerminalNode)) child.accept(this);
            }
        }
        return null;
    }

    public void runTask(String name) throws Exception {
        if (project == null) return;
        Task t = project.tasks.get(name);
        if (t == null) {
            System.out.println("Task tidak ditemukan: " + name);
            return;
        }

        for (String sub : t.subTasks) runTask(sub);

        String projectOutPath = rootOutDir + File.separator + project.name;

        for (String cmdStr : t.commands) {
            if (cmdStr.equals("ORGANIZE")) {
                organizeSmart(projectOutPath); 
                continue;
            }
            if (cmdStr.equals("FIX_DEPS")) {
                fixDependencies(projectOutPath);
                continue;
            }

            String[] parts = cmdStr.split("\\|");
            String type = parts[0];
            
            String arg1 = (parts.length > 1) ? parts[1].replace("{OUT}", projectOutPath) : "";
            String arg2 = (parts.length > 2) ? parts[2].replace("{OUT}", projectOutPath) : "";

            switch (type) {
                case "ECHO": System.out.println("[ECHO] " + arg1); break;
                case "MKDIR": createDir(arg1); break;
                case "COPY": copyFileOrDir(arg1, arg2); break;
                case "DELETE": deletePath(arg1); break;
                case "RUN":
                    if (arg1.equalsIgnoreCase("COMPILE")) {
                        smartCompile(projectOutPath); 
                        break; 
                    }
                    if (arg1.startsWith("START ")) {
                        String mainClass = arg1.substring(6).trim();
                        smartRun(projectOutPath, mainClass);
                        break; 
                    }

                    if (System.getProperty("os.name").toLowerCase().contains("win")) {
                        arg1 = arg1.replace("/", "\\");
                    }
                    
                    if (arg1.trim().startsWith("jar ")) {
                         String[] cmdParts = arg1.split(" ");
                         if(cmdParts.length >= 5) JarPackager.createJar(cmdParts[4], cmdParts[2]);
                    } else {
                        Executor.exec(arg1);
                    }
                    break;
            }
        }
    }
    private void organizeSmart(String projectOutPath) {
        System.out.println(">>> [SMART ORGANIZE] Scanning & Mirroring Source...");
        if (this.sourcePath == null) return;

        Path sourceRoot = Paths.get(this.sourcePath);
        Path destRoot = Paths.get(projectOutPath, "src");

        try (Stream<Path> stream = Files.walk(sourceRoot)) {
            stream.filter(p -> p.toString().endsWith(".java"))
                  .forEach(source -> {
                      try {
                          Path relativePath = sourceRoot.relativize(source);
                          Path dest = destRoot.resolve(relativePath);
                          
                          if (dest.getParent() != null) Files.createDirectories(dest.getParent());
                          
                          Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
                          System.out.println("    + Source: " + relativePath);
                      } catch (IOException e) {
                          System.err.println("    [FAIL] " + e.getMessage());
                      }
                  });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void smartCompile(String projectPath) throws Exception {
        System.out.println(">>> [SMART COMPILE] Building Project...");
        
        String srcDir = projectPath + File.separator + "src";
        String binDir = projectPath + File.separator + "bin";
        String libDir = projectPath + File.separator + "lib";

        List<String> sourceFiles = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(srcDir))) {
            List<String> result = walk.map(x -> x.toString())
                                      .filter(f -> f.endsWith(".java"))
                                      .collect(Collectors.toList());
            sourceFiles.addAll(result);
        }

        if (sourceFiles.isEmpty()) {
            System.out.println("!!! Tidak ada file Java untuk di-compile.");
            return;
        }

        StringBuilder classPath = new StringBuilder(binDir);
        String pathSep = System.getProperty("os.name").toLowerCase().contains("win") ? ";" : ":";
        
        File libFolder = new File(libDir);
        File[] jars = libFolder.listFiles((dir, name) -> name.endsWith(".jar"));
        if (jars != null) {
            for (File jar : jars) classPath.append(pathSep).append(jar.getAbsolutePath());
        }

        StringBuilder cmd = new StringBuilder();
        cmd.append("javac -d \"").append(binDir).append("\"");
        cmd.append(" -cp \"").append(classPath.toString()).append("\" ");
        for (String src : sourceFiles) cmd.append("\"").append(src).append("\" ");

        System.out.println("    [CMD] Mengompilasi " + sourceFiles.size() + " file...");
        Executor.exec(cmd.toString());
    }

    private void smartRun(String projectPath, String mainClass) throws Exception {
        System.out.println(">>> [SMART RUN] Launching: " + mainClass);
        
        String binDir = projectPath + File.separator + "bin";
        String libDir = projectPath + File.separator + "lib";
        String pathSep = System.getProperty("os.name").toLowerCase().contains("win") ? ";" : ":";

        StringBuilder classPath = new StringBuilder(binDir);
        File libFolder = new File(libDir);
        File[] jars = libFolder.listFiles((dir, name) -> name.endsWith(".jar"));
        if (jars != null) {
            for (File jar : jars) classPath.append(pathSep).append(jar.getAbsolutePath());
        }

        String cmd = "java -cp \"" + classPath.toString() + "\" " + mainClass;
        Executor.exec(cmd);
    }

    private void organizeStructure(String projectOutPath) {
        System.out.println(">>> [ORGANIZE-LEGACY] Memulai scan folder...");

        if (this.sourcePath == null) {
            System.err.println("[ERR] Path 'FROM' tidak didefinisikan di DSL.");
            return;
        }

        Path sourceRoot = Paths.get(this.sourcePath);
        Path destSrc = Paths.get(projectOutPath, "src");

        if (!Files.exists(sourceRoot)) {
            System.err.println("[FATAL] Folder Sumber TIDAK DITEMUKAN di: " + sourceRoot.toAbsolutePath());
            System.err.println("        Pastikan path benar dan tidak ada typo.");
            return;
        }

        try {
            if (!Files.exists(destSrc)) Files.createDirectories(destSrc);
            
            final int[] count = {0};

            try (Stream<Path> stream = Files.walk(sourceRoot)) {
                stream.filter(p -> p.toString().endsWith(".java"))
                      .forEach(source -> {
                          try {
                              // Pindahkan semua file ke root src (Flattening)
                              Path dest = destSrc.resolve(source.getFileName());
                              Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
                              System.out.println("    [COPY] " + source.getFileName());
                              count[0]++;
                          } catch (IOException e) {
                              System.err.println("    [FAIL] Gagal copy: " + e.getMessage());
                          }
                      });
            }
            
            if (count[0] == 0) {
                System.out.println("!!! WARNING: Tidak ada file .java ditemukan di folder tersebut.");
            } else {
                System.out.println(">>> [SUKSES] " + count[0] + " file berhasil dipindahkan.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fixDependencies(String projectOutPath) {
        System.out.println(">>> [DEPS] Mengunduh dependensi...");
        for (Dependency d : project.dependencies) {
            DependencyDownloader.download(projectOutPath, d.name, d.version);
        }
    }

    private void createDir(String path) {
        new File(path).mkdirs();
    }

    private void deletePath(String pathStr) {
        try {
            Path path = Paths.get(pathStr);
            if (Files.exists(path)) {
                Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void copyFileOrDir(String src, String dest) {
        try {
            File sourceFile = new File(src);
            File destFile = new File(dest);
            if (sourceFile.isDirectory()) {
                createDir(dest);
                String[] files = sourceFile.list();
                if (files != null) for (String file : files) copyFileOrDir(new File(sourceFile, file).getPath(), new File(destFile, file).getPath());
            } else {
                if(destFile.getParentFile() != null) destFile.getParentFile().mkdirs();
                Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) { System.err.println("Copy failed: " + e.getMessage()); }
    }
}
