package techproed.day08_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass methodları static olmak zorundadır.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforaClass");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test
    public void test02() {
        System.out.println("test02");

    }

    @Test
    public void test03() {
        System.out.println("test03");



    }
}
