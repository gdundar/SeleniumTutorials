package Selenium.tests.day10_css_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultipleButtonsWithCSS {

    String button1Locator = "[onclick='button1()']";
    String button2Locator = ".btn.btn-primary:nth-of-type(2)";
    String button3Locator = "[id^='button_']";
    String button4Locator = "[id$='_button']:nth-of-type(4)";
    String button5Locator = "[onclick*='5']";
    String button6Locator = "#disappearing_button";
    String result = "#result";

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    //@Ignore
    @Test
    public void button1Test(){
        driver.findElement(By.cssSelector(button1Locator)).click();
        String expectedMessage = "Clicked on button one!";
        String actualMessage = driver.findElement(By.cssSelector(result)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        //throw new SkipException("Skip the test);
    }

    @Test
    public void button2Test(){
        driver.findElement(By.cssSelector(button2Locator)).click();
        String expectedMessage = "Clicked on button two!";
        String actualMessage = driver.findElement(By.cssSelector(result)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
