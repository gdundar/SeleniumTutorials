package my_practices.exercises.quickAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class SleepAndImplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDown(){
       driver.close();
    }

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.id("finish")).getText());
    }

    @Test
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.id("finish")).getText());

    }

    @Test
    public void implicitWait2(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
        System.out.println(driver.findElement(By.cssSelector("p[id='message']")).getText());
        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();
        System.out.println(driver.findElement(By.cssSelector("p[id='message']")).isDisplayed());
        System.out.println(driver.findElement(By.cssSelector("p[id='message']")).getText());

    }
}
