package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {
    /*
    Eger bir sayfadaki bir buttona tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye sag klik yapip
    locate alamiyorsak, bu bir Js Alert'tur.
    Js Alert'u handle edebilmek icin driver'imizi o pencereye gecirmemeiz gerekir. Bunun icin; driver objemizi kullanarak
    swichTo() methoduyla alert() methodunu kullanarak js alert'e gecir yapmis oluruz.
    accept() ya da dismiss() methodlariyla js Alert'u onaylar ya da iptal ederek kapatiriz
 */

    @Test
    public void acceptAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(actualResult,expectedResult);


    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "successfuly";
        Assert.assertFalse(actualResult.contains(expectedResult));
    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("serbulent");
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "serbulent";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
