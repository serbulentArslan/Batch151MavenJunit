package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void name() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(box).perform();

        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        Assert.assertEquals(getTextAlert(),"You selected a context menu");

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();

    }
}
