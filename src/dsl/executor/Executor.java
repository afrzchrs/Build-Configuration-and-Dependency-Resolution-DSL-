package dsl.executor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Executor {
    
    public static void exec(String cmd) throws Exception {
        System.out.println("[EXEC] " + cmd); 
        
        ProcessBuilder pb = new ProcessBuilder();
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        
        if (isWindows) {
            pb.command("cmd.exe", "/c", cmd);
        } else {
            pb.command("bash", "-c", cmd);
        }
        
        pb.inheritIO(); 
        
        Process p = pb.start();
        int exitCode = p.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Command failed with exit code: " + exitCode);
        }
    }
}