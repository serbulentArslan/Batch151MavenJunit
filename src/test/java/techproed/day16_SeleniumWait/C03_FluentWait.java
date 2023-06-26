package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    /*
    bizim belirttigimiz aralıklarda (saniye/salise) bekler.
     */
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start button tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! yazısının sitede oldugunu test et
        WebElement text = driver.findElement(By.xpath("(//h4)[2]"));

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)) //max bekleme süresini belirtir.
                .pollingEvery(Duration.ofMillis(200)); //200 milisaniye aralıklarla kontrol et.

        wait.until(ExpectedConditions.visibilityOf(text));

        Assert.assertEquals("Hello World!",text.getText());

    }
}
