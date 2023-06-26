package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
        /*
        Bir web sitesini test ettiğimizde download işlemi yapıldıgı zaman dosyanın pc ye inip inmediğini kontrol
        edebilmek için Files class'ından exists() methodunu kullanarak parametre olarak
        Paths.get(dosya yolu) methodunu kullanarak dosyanın varlıgını kontrol edebiliriz.
         */

        String filePath = "C:/Users/serars/OneDrive/Masaüstü/1686370856508.jpeg";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test
    public void test02() {
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");
        System.out.println(isletimSistemiAdi);

        System.out.println(System.getProperty("user.home"));

        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");
        } else if (isletimSistemiAdi.contains("mac")) {
            farkliYol = "/Users/serars";
        }
    }

    @Test
    public void test03() {
        String filePath = "C:/Users/serars/OneDrive/Masaüstü/1686370856508.jpeg";

        File file = new File(filePath);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
    }
}
