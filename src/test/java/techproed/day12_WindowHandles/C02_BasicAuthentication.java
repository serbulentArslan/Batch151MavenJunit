package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    @Test
    public void name() throws InterruptedException {

    //Aşağıdaki bilgileri kullanarak authentication yapınız:
    //Url: https://the-internet.herokuapp.com/basic_auth
    //Username: admin
    //Password: admin
    //Başarılı girişi doğrulayın.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        Assert.assertTrue(driver.findElement(By.xpath("//p")).isDisplayed());

        //Elemental selenium yazısına tıkla
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        //yeni pencereye driver'ı geçir
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        //başlgın elemental selenium oldugunu doğrularyın
        Assert.assertNotEquals("Elemental Selenium", driver.getTitle());

        //ddm den java seçin
        WebElement ddm = driver.findElement(By.cssSelector("select[class]"));
        Select select = new Select(ddm);

        select.selectByVisibleText("Java");




    }
}
