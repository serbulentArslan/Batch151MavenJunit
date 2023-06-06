package techproed.day07_MavenJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    /*
        Notasyonlara sahip methodlar olusturabilmek icin mouse+sag tik +generate(kisayol alt + insert) yaparak
        after methodu icin teardown'u seceriz.
        before methodu icin setup'i seceriz.
        test methodu icin de test'i seceriz
            Junit framework'unde testlerimizi sıralama yapabilmek için ekstra bir notasyok yoktur.
            Eger belli bir sıralamada çalıştırma istersek method isimlerini alfabetik ve numeric olarak
            belirtmemiz gerekir.
    */

    @Before
    public void setUp() {
        System.out.println("BEFORE: Her test methodundan önce bir kez çalışır");
    }

    @Test
    public void test1() {
        System.out.println("Test 1 methodu çalıştı");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 methodu çalıştı");
    }

    @Test
    public void test3() {
        System.out.println("Test 3 methodu çalıştı");
    }

    @After
    public void tearDown() {
        System.out.println("AFTER: Her test methodundan sonra bir kez çalışır.");
    }
}
