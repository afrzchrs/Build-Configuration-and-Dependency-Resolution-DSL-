package dsl.executor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class JarPackager {

    public static void createJar(String sourceDir, String outputFile) {
        System.out.println("[JAR] Packing: " + sourceDir + " -> " + outputFile);
        
        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        // Menentukan Main-Class agar jar bisa dijalankan (Opsional, default ke Main)
        manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, "Main");

        try (JarOutputStream target = new JarOutputStream(new FileOutputStream(outputFile), manifest)) {
            Path root = Paths.get(sourceDir);
            if (!Files.exists(root)) {
                System.err.println("[JAR ERR] Source directory not found: " + sourceDir);
                return;
            }

            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // Hitung path relatif untuk entry di dalam jar (misal: Main.class)
                    String entryName = root.relativize(file).toString().replace("\\", "/");
                    JarEntry entry = new JarEntry(entryName);
                    entry.setTime(file.toFile().lastModified());
                    target.putNextEntry(entry);
                    Files.copy(file, target);
                    target.closeEntry();
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("[JAR] Success created: " + outputFile);
        } catch (IOException e) {
            System.err.println("[JAR ERR] Failed to create jar: " + e.getMessage());
        }
    }
}