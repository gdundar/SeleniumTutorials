package selenium.tests.day9_locators_review;

import my_practices.exercises.locators.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static selenium.utilities.SeleniumUtils.waitPlease;

public class AbsoluteXpathDemo {

    WebDriver driver = BrowserFactory.getDriver("chrome");
    String nameLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']";
    String emailLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']";
    String signUpLocator = "html/body/div/div[2]/div/div/form/button";

    @BeforeMethod // it runs before every class fore very test
    public void setup(){
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

    }

    @Test
    public void test1(){
        //enter username
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']")).sendKeys("Automationengineer");
        waitPlease(2);
        //enter email address
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']")).sendKeys("autoengineer@gmail.com");
        waitPlease(2);
        //click submit button
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/button")).click();
        waitPlease(2);
        //comparing the results
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.xpath("html/body/div/div[2]/div/div/h3")).getText();
        //we'll see the result
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void negativeTest(){
        //sending negative test username
        driver.findElement(By.xpath(nameLocator)).sendKeys("Tom Smith");
        waitPlease(2);
        //sending negative test gmail
        driver.findElement(By.xpath(emailLocator)).sendKeys("hello@gmail.com");
        waitPlease(2);
        //clicking the signup button
        driver.findElement(By.xpath(signUpLocator)).click();
    }

    @AfterMethod //quits the website after each method
    public void tearDown(){
        driver.quit();
    }
}
