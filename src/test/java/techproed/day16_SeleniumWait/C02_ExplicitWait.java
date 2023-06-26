package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start button tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! yazısının sitede oldugunu test et
        WebElement text = driver.findElement(By.xpath("(//h4)[2]"));

        visibleWait(text,20);
        Assert.assertEquals("Hello World!",text.getText());

    }
}
