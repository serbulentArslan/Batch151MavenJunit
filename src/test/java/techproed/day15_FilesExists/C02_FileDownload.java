package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        String filePath = "C:\\Users\\serars\\Downloads\\b10 all test cases, code.docx";

        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("dosya bulunamadı");
        }
        //https://testcenter.techproeducation.com/index.php?page=file-download
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //download adresine gidelim
        driver.findElement(By.xpath("//a[2]")).click();
        Thread.sleep(1500);

        //b10 all test cases dosyasını indirelim
        //Dosyanın başarıyla indirilip indirlimedigini kontrol edin.


        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
