package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {
    /*
    Selenium Wait:
            Implicitly Wait : Driver'ı olusturduktan sonra sayfadaki tum webelementlerin etkileşime girebilmesi
                              için belirtmiş oldugumuz max süre kadar bekler.
            Explicit Wait :   Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için max belirtmiş
                              oldugumuz süre kadar default olarak yarım saniyelik aralıklarla bekler.
     */
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start button tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! yazısının sitede oldugunu test et
        WebElement text = driver.findElement(By.xpath("(//h4)[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOf(text));

        Assert.assertEquals("Hello World!",text.getText());

    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start button tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! yazısının sitede oldugunu test et
        WebElement text = driver.findElement(By.xpath("(//h4)[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));

        Assert.assertEquals("Hello World!",text.getText());
    }
}
