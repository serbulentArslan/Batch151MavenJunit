package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void test() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
                String editorYazisi = driver.findElement(By.xpath("//h3")).getText();
                Assert.assertTrue(editorYazisi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
                driver.switchTo().frame("mce_0_ifr");
                WebElement textbox = driver.findElement(By.xpath("//p"));
                textbox.clear();

                textbox.sendKeys("Bu texubox iframe içerisindedir");


    }
}
