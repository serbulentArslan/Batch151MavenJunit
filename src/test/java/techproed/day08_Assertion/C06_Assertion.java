package techproed.day08_Assertion;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("test başarılı");
    }

    @Test
    public void test02() {
        Assert.assertEquals(3,2);
        System.out.println("test başarılı");
    }

    @Test
    public void test03() {
        Assert.assertNotEquals(5,4);
        System.out.println("test başarılı");
    }

    @Test
    public void test04() {
    String actualName = "Serbo";
    String expectedName = "serbo";

    Assert.assertEquals(expectedName,actualName);
        System.out.println("test başarılı");
    }

    @Test
    public void test05() {
        int yas = 50;
        int emeglilikYas = 65;

        Assert.assertTrue(emeglilikYas>yas);
        System.out.println("basarili");
    }

    @Test
    public void test06() {
        int yas = 50;
        int emeglilikYas = 65;

        Assert.assertTrue(emeglilikYas<yas);
        System.out.println("basarili");
    }

    @Test
    public void test07() {
        int yas = 50;
        int emeglilikYas = 65;

        Assert.assertFalse(emeglilikYas<yas);
        System.out.println("basarili");
    }

}
