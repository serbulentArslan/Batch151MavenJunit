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

public class C03_DropDown {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        //programming languages ddm den istediginiz 4 secenegi seciniz.
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //sadece seçili olan option ları yazdırmak istersek
        select.getAllSelectedOptions().forEach(t-> System.out.println(t.getText()));

        //4 tane seçtigini doğrula
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //seçili olanlardan ilkini yazdırın
        System.out.println(select.getFirstSelectedOption().getText());

        //ilkinin java oldugunu dogrula
        Assert.assertEquals("Java", select.getFirstSelectedOption().getText());

        //seçeneklerin hepsini kaldıralım
        select.deselectAll();

        //visibleText olarak seçim yapacağımız bir method olusturup programming languages ddm den bir seçnek sçelim
        selectVisibleText(diller,"Java");

        //index olarak seçim yapacağımız bir method olusturup programming languages ddm den bir seçnek sçelim
        selectByIndex(diller,2);

        //value olarak seçim yapacağımız bir method olusturup programming languages ddm den bir seçnek sçelim
        selectValue(diller,"js");
    }
    public void selectVisibleText(WebElement ddm, String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    public void selectByIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    public void selectValue(WebElement ddm, String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
}
