package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void name() {
        driver.get("https://techproeducation.com");
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.END).build().perform();
        action.sendKeys(Keys.HOME).build().perform();
        //build() metyodu action ları birleştirmek için kullanılan methoddur. Birden fazla olusturulan actionları birleştirir.

        //release() methodu mouse u bırakır.
        action.scrollByAmount(0,1500).perform();


    }
}
