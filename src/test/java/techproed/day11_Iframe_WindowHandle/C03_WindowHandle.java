package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String expectedTitleTechPro = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitleTechPro,driver.getTitle());

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:

        driver.switchTo().window(linkedinWindowHandle);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        driver.switchTo().window(techproWindowHandle);
        //linkedIn sayfasına geçiniz:


    }
}
