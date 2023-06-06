package techproed.day07_MavenJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //        1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //        2.Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //        3.Login alanine “username” yazdirin
        WebElement login = driver.findElement(By.cssSelector("input[id='user_login']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        driver.navigate().back();

        //        6.online banking altında Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //        7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //        8.tarih kismina “2020-09-10” yazdirin
        WebElement amount = driver.findElement(By.id("sp_amount"));
        amount.sendKeys("3500",Keys.TAB,"2020-09-10");

        //        9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //        10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement text = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String actualText = text.getText();
        String expectedText = "The payment was successfully submitted.";

        if (actualText.equals(expectedText)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        driver.close();



    }
}
