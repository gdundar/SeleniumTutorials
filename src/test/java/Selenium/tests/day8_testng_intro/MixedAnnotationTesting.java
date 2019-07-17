package Selenium.tests.day8_testng_intro;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MixedAnnotationTesting {

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method");
    }

    @Test
    public void test1(){
        System.out.println("I am a test");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method");
    }

    @AfterClass
    public void  afterClass(){
        System.out.println("After class");
    }

}
