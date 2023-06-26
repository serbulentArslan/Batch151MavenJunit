package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void name() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        /*
           Cookie'leri listelemek istersek
                   driver.manage().getCookies() methodu ile bir Set ya da ArraList'e atarak listeyebiliriz
        */
        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println); lambda ile

        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+ ".ci cookie : "+w.getName());
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin  5-ismi “en sevdigim cookie”

        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();
        for (Cookie w : cookieSet){
            System.out.println(w);
        }
        Assert.assertTrue(driver.manage().getCookieNamed("en sevdigim cookie").getValue().equals("cikolatali"));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int before = cookieSet.size();
        driver.manage().deleteCookieNamed("skin");

        cookieSet = driver.manage().getCookies();
        int after = cookieSet.size();

        Assert.assertEquals(1,before-after);

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();

        Assert.assertTrue(cookieSet.size()==0);
    }
}
