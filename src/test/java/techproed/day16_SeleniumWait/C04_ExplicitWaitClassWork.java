package techproed.day16_SeleniumWait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitWaitClassWork extends TestBase {
    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me to open an Alert button tıkla
        driver.findElement(By.xpath("//*[@id='alert']")).click();

        //çıkan alaerti kapatalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }
}
