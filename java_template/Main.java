import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   APLIKASI UTAMA (FLEKSIBEL/DINAMIS)     ");
        System.out.println("==========================================");

        System.out.print("1. Cek Library Gson... ");
        try {
            Class<?> gsonClass = Class.forName("com.google.gson.Gson");
            
            Object gsonInstance = gsonClass.getDeclaredConstructor().newInstance();
            Method toJsonMethod = gsonClass.getMethod("toJson", Object.class);
            String json = (String) toJsonMethod.invoke(gsonInstance, "Data Tes");
            
            System.out.println("ADA! (Hasil: " + json + ")");
        } catch (ClassNotFoundException e) {
            System.out.println("TIDAK ADA (Dilewati)");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("2. Cek Library Commons Lang... ");
        try {
            Class<?> stringUtils = Class.forName("org.apache.commons.lang3.StringUtils");
            Method upperCase = stringUtils.getMethod("upperCase", String.class);
            String hasil = (String) upperCase.invoke(null, "halo dsl");
            
            System.out.println("ADA! (Hasil: " + hasil + ")");
        } catch (ClassNotFoundException e) {
            System.out.println("TIDAK ADA (Dilewati)");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("3. Cek Library Jsoup... ");
        try {
            Class<?> jsoup = Class.forName("org.jsoup.Jsoup");
            Method parse = jsoup.getMethod("parse", String.class);
            Object doc = parse.invoke(null, "<html><title>Judul</title></html>");
            
            Method titleMethod = doc.getClass().getMethod("title");
            String title = (String) titleMethod.invoke(doc);

            System.out.println("ADA! (Judul HTML: " + title + ")");
        } catch (ClassNotFoundException e) {
            System.out.println("TIDAK ADA (Dilewati)");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("==========================================");
    }
}