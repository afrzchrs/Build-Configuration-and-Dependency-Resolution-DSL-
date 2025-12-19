import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestPath {
    public static void main(String[] args) {
        String pathString = "C:/javaprojects/reservasihotel - Copy"; 

        System.out.println("=== DIAGNOSTIK PATH ===");
        System.out.println("Path Input: " + pathString);
        
        File folder = new File(pathString);
        System.out.println("Apakah Folder Ada? : " + folder.exists());
        System.out.println("Apakah Ini Folder? : " + folder.isDirectory());
        System.out.println("Absolut Path       : " + folder.getAbsolutePath());

        if (folder.exists()) {
            System.out.println("\n[SCANNING FILES...]");
            try (Stream<Path> stream = Files.walk(Paths.get(pathString))) {
                stream.filter(p -> p.toString().endsWith(".java"))
                      .forEach(p -> System.out.println(" - DITEMUKAN: " + p.getFileName()));
            } catch (Exception e) {
                System.out.println("ERROR SCANNING: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("\n[SOLUSI]");
            System.out.println("Java tidak melihat folder ini. Coba rename folder 'reservasihotel - Copy'");
            System.out.println("menjadi 'reservasi_hotel' (tanpa spasi) lalu update path di DSL.");
        }
    }
}
