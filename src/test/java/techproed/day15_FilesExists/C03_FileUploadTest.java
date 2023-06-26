package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {

    @Test
    public void test01() {

        String filePath = "C:\\Users\\serars\\OneDrive\\Masaüstü\\1686370856508.jpeg";

        //https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna tıkla
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        //chooseFileButton.click();
        /*
        eger dosya seç butonuna basmamız istenirse ve otomasyon ile bu butona click yapmak istedigimizde exception
        alıyorsak direkt upload yapmak istedigimiz dosya yolunu alıp sendKeys methodu ile dosyayı
        sayfaya upload yapabiliriz.
         */
        chooseFileButton.sendKeys(filePath);




        //yuklemek istediginiz dosyayı seç
        //upload butonuna basalım
        driver.findElement(By.id("file-submit")).click();

        //File uploaded yazısının çıktıgını test edelim
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isDisplayed());
    }
}
