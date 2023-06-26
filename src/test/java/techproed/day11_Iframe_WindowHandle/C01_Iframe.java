package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {
       /*
        Bir HTML dokumaninin icine yerlestirilmis baska bir HTML dokumanina inline frame yani IFRAME denir
        Bir sayfada iframe varsa iframe icindeki webelementi handle edebilmek icin switchTo() methodu ile iframe'e gecis
        yapmamiz gerekir.Eger gecis yapmazsak nosuchelementexception aliriz.
        Alert'ten farki alert ciktiginda hicbir webelementi locate edemeyiz. iframe olsada locate ederiz fakat
        handle edemeyiz
       */

    @Test
    public void iframe() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String actualText = driver.findElement(By.xpath("(//p)[1]")).getText();
        String expectedText = "black border";
        Assert.assertTrue(actualText.contains(expectedText));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        WebElement iframe = driver.findElement(By.cssSelector("iframe[src='/index.php']"));
        driver.switchTo().frame(iframe);
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        //Son olarak footer daki 'Povered By' yazisini varligini test edilip
        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.xpath("(//p[text()='Povered By'])[1]")).isDisplayed());


          /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir
		            üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */
    }
}
