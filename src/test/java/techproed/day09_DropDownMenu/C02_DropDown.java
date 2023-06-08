package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
     /*
    DROPDOWN    -->Alt basliklarin oldugu acilir menu listesidir.
    Dropdown'u handle(automate) etmek icin
        1-Dropdown menuyu ilk olarak locate ederiz
        2-Select objesi olustururuz.
        3-Select objesinin ddm webelementinin icerigine ve seceneklerine erisim saglamasi ici
        SELECT sinifina arguman olarak locate ettigimiz webelementi koyariz.
        SYNTAX:
                Select select = new Select(ddm webelementi);
        4-Select class'i, sadece <select> tag'i ile olusturulmus dropdown menulere uygulanabilir.
        5-Select objesi ddm'yü handle edebilemk için 3 method kullanır
            1) select.selectByVisibleText; -> DDM'deki elemente görünür metin ile ulaşmak içindir.
            2) select.selectByValue; -> Elementin degeri ile ulaşmak için kullanılır.(option tag'larındaki deger ile)
            3) select.selectByIndex; -> Index ile ulaşmak için kullanılır
        6-getOptions() -> Locate ettigimiz ddm'deki tum seçenekleri bize List olarak verir.
        7-getFirstSelectedOption() seçili olanların ilkini verir.
     */

    WebDriver driver;
    /*
        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        -3 farklı test methodu oluşturalım
            1.Method:
                a. Yil,ay,gün dropdown menu'leri locate ediniz
                b. Select objesi olustur
                c. Select object i kullaarak 3 farkli sekilde secim yapiniz
            2.Method:
                a. Tüm eyalet isimlerini yazdıralım
            3.Method:
                a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

     */
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void method1() {
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));

        Select select = new Select(year);
        select.selectByVisibleText("1999");
        select = new Select(month);
        select.selectByVisibleText("February");
        select = new Select(day);
        select.selectByVisibleText("3");
    }

    @Test
    public void method2() {
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions();
        states.forEach(t-> System.out.println(t.getText()));

    }

    @Test
    public void method3() {
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(state);
        WebElement firstSelected = select.getFirstSelectedOption();
        String actualSelected = firstSelected.getText();
        String expectedSelected = "Select a State";
        Assert.assertEquals(actualSelected,expectedSelected);
    }
}
