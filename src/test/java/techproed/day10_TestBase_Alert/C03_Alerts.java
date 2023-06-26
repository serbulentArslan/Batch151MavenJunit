package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alerts extends TestBase {

    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.id("alertButton")).click();

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        Assert.assertEquals("You clicked a button",getTextAlert());

        //Ve alert'ü kapatalım
        acceptAlert();
    }
}
