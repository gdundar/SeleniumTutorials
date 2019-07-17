package Selenium.tests.day8_testng_intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaTesNGDemo {

    @Test
    public void test1(){
        String a = "A";
        String b = "A";

        Assert.assertEquals(a,b);

    }

    @Test
    public void test2(){
        String str1 = "Apple";
        String str2 = "Orange";
        Assert.assertEquals(str1, str2);
    }

    @Test
    public void test3(){
        String str1 = "Test";
        String str2 = "TestNG";
        Assert.assertTrue(str2.contains(str1));
    }

    @Test
    public void test4(){
        Assert.assertFalse(false);
    }
}
