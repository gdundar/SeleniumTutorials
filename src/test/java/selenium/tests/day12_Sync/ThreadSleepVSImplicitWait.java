package selenium.tests.day12_Sync;

import my_practices.exercises.locators.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepVSImplicitWait {

    String helloWorldMessageLocator = "#finish";
    String startButtonLocator = "#start > button";
    WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        //either implicit wait or the below try - catch
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.findElement(By.cssSelector(startButtonLocator)).click();
        String expectedResult = "Hello World!";
        try{
            Thread.sleep(6000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        String actualResult = driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String expectedResult = "Hello World!";
        try{
            Thread.sleep(6000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        String actualResult = driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
