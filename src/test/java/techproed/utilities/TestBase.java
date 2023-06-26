package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {

    /*
    TestBase Class'ından object olusturmanın onune geçmek için bu Class'ı abstract yapabiliriz.
    Bu Class'a extends yaptıgımız test class'larından ulaşabiliriz.
     */

    protected WebDriver driver;
    @Before
    public void setUp() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception{
        //driver.quit();
    }

    //Selenium wait/Explicit Wait
    public void visibleWait(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Selenium wait/Explicit Wait
    public void visibleWait(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //AlertWait
    public void alertWait(int seconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //AcceptAlert
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }

    public void sendKeysAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //SwitchTo Window-1
    public void switchToWindow1(int index){
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }
    //SwitchTo Window-2
    public void switchToWindow2(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }
}
