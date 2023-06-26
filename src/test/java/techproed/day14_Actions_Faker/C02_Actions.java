package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void eee() {
        driver.get("https://jqueryui.com/droppable/");
        Actions action = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropElement = driver.findElement(By.xpath("//div[@id='droppable']"));
        action.clickAndHold(dragElement).moveToElement(dropElement).release().perform();
    }

    @Test
    public void name() {
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropElement = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions action = new Actions(driver);

        action.dragAndDrop(dragElement,dropElement).perform();



    }
}
