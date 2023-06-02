package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");

        //arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        //“Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayisini yazdiralim
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String[] numberOfResult = resultText.getText().split(" ");
        System.out.println(numberOfResult[2]);

        //Ilk urunu tiklayalim
        WebElement firsProduct = driver.findElement(By.xpath("(//h2/a/span)[1]"));
        firsProduct.click();

        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> allTitles = driver.findElements(By.xpath("//h1 | //h2"));
        allTitles.forEach(t-> System.out.println(t.getText()));

    }
}
