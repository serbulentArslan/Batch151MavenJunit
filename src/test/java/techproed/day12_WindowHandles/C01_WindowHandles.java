package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void name() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String herokuapp = driver.getWindowHandle();
        System.out.println(herokuapp);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String text = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(text,expectedText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals(driver.getTitle(),"The Internet");

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        /*
        Bir button'a click yaptigimizda kontrolumuz disinda yeni bir sekme ya da pencere acilirsa , yeni acilan pencerenin
        handle degerini bilmedigim icin normal getWindowHandle ile driver'imi yeni pencereye geciremem. Bunu getWindowHandles()
        methoduyla acilan tum pencereleri bir Set'e assign edip , ilk actigimiz pencere degilse ikinci acilan yeni penceredir
        mantigiyla bir loop icinde cozebiliriz
        */
        Set<String> windows = driver.getWindowHandles();
        for (String w: windows) {
            if (!w.equals(herokuapp)){
                driver.switchTo().window(w);
            }
        }
        String newPage = driver.getWindowHandle();


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        Assert.assertEquals("New Window",driver.getTitle());

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(herokuapp);
        Assert.assertEquals("The Internet",driver.getTitle());

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(newPage);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(herokuapp);
    }
}
