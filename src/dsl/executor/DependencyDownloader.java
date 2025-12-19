package dsl.executor;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DependencyDownloader {
    
    // URL Repository Maven Central
    private static final String MAVEN_REPO = "https://repo1.maven.org/maven2";

    /**
     * @param outputDir 
     * @param dependencyString 
     * @param version 
     */
    public static void download(String outputDir, String dependencyString, String version) {
        String[] parts = dependencyString.split(":");
        if (parts.length != 2) {
            System.err.println("[ERR] Format dependency salah! Gunakan 'Group:Artifact'. Contoh: 'com.google.code.gson:gson'");
            return;
        }
        
        String groupId = parts[0];
        String artifactId = parts[1];

        String libPath = outputDir + "/lib";
        File libDir = new File(libPath);
        if (!libDir.exists()) libDir.mkdirs();

        String fileName = artifactId + "-" + version + ".jar";
        File destination = new File(libDir, fileName);

        if (destination.exists()) {
            System.out.println("[SKIP] Library sudah ada: " + fileName);
            return;
        }

        try {
            System.out.println("[DOWNLOADING] " + dependencyString + " (" + version + ")...");
            
            String groupPath = groupId.replace(".", "/");
            
            String downloadUrl = String.format("%s/%s/%s/%s/%s", 
                MAVEN_REPO, groupPath, artifactId, version, fileName);

            URL url = new URL(downloadUrl);
            try (InputStream in = url.openStream()) {
                Files.copy(in, destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("[SUCCESS] Tersimpan di: " + destination.getAbsolutePath());
            }
        } catch (Exception e) {
            System.err.println("[ERROR] Gagal mengunduh " + fileName + ". Pastikan koneksi internet aktif dan nama package benar.");
            System.err.println("Detail: " + e.getMessage());
        }
    }
}