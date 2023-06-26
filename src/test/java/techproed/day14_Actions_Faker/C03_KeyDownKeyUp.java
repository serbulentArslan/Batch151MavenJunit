package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void name() {
        driver.get("https://google.com");

        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions action = new Actions(driver);
        action.keyDown(searchBox, Keys.SHIFT).sendKeys("selenium").keyUp(searchBox,Keys.SHIFT)
                .sendKeys(" java",Keys.ENTER).perform();
    }

    @Test
    public void ctrlxv() {
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("selenium",Keys.ENTER);

        searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.CONTROL,"a");

        searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.CONTROL,"x");

        driver.get("https://google.com");
        searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.CONTROL,"v",Keys.ENTER);

    }
}
