package vyTrackApplication.smokeTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vyTrackApplication.utilities.Wait;

import java.util.concurrent.TimeUnit;

public class MenuOptions_Driver {
        WebDriver driver;
        String userName = "user9";
        String password = "UserUser123";


        @BeforeClass
    public void beforeClass(){
            //set the environment with driver, website and log in
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://qa2.vytrack.com/user/login");
            Wait.waitPlease(1);
            driver.findElement(By.id("prependedInput")).sendKeys(userName);
            Wait.waitPlease(1);
            driver.findElement(By.id("prependedInput2")).sendKeys(password);
            Wait.waitPlease(1);
            driver.findElement(By.id("_submit")).click();
            Wait.waitPlease(1);


        }

        @BeforeMethod
        public void beforeMethod(){
            Wait.waitPlease(2);
        }
        @AfterMethod
        public void afterMethod(){
            Wait.waitPlease(2);
        }


        @Test//passed
       public void verifyVehiclesPageTitle(){
            //clicking on fleet tab
            Wait.waitPlease(2);
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
            Wait.waitPlease(2);
            driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();
            Wait.waitPlease(2);

            String expectedTitle = driver.getTitle();
            String actualTitle = "Car - Entities - System - Car - Entities - System";
            Assert.assertEquals(expectedTitle, actualTitle);
        }
        @Test//passed
        public void verifyVehiclesPageName(){
            //clicking on fleet tab
            Wait.waitPlease(2);
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
            Wait.waitPlease(2);
            driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();

            Wait.waitPlease(1);
            String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
            String expectedName = "Cars";

            Assert.assertEquals(actualName, expectedName);

        }

        @Test//failed
    public void verifyAccountPageTitle(){
            Wait.waitPlease(1);
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
            Wait.waitPlease(1);
            driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();

            String expectedTitle= driver.getTitle();
            String actualTitle = "Accounts - Customers";

            Assert.assertEquals(expectedTitle, actualTitle);

        }
    @Test//passed
    public void verifyAccountPageName(){
        Wait.waitPlease(1);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        Wait.waitPlease(1);
        driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();

        String expectedPageName= driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(), 'Account')]")).getText();
        String actualPageName = "Accounts";

        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName, expectedPageName);

    }

        @Test//passed
    public void verifyContactsPageTitle(){
            Wait.waitPlease(1);
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
            Wait.waitPlease(1);
            driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
            Wait.waitPlease(1);
            String expectedTitle = driver.getTitle();
            String actualTitle = "Contacts - Customers";
            Wait.waitPlease(1);
            Assert.assertEquals(actualTitle, expectedTitle);

        }

        @Test//passed
    public void verifyContactsPageName(){
            Wait.waitPlease(1);
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
            Wait.waitPlease(1);
            driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();

            String expectedName = driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Contacts')]")).getText();
            String actualName = "Contacts";
            Assert.assertEquals(actualName, expectedName);
        }
        @Test//passed
    public  void calendarPageTitle(){
            Wait.waitPlease(1);
            driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
            Wait.waitPlease(1);
            driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();
            Wait.waitPlease(1);
            String excpectedTitle = driver.getTitle();
            String actualTitle = "Calendar Events - Activities";
            Wait.waitPlease(1);
            Assert.assertEquals(actualTitle, excpectedTitle);

        }

    @Test//passed
    public  void calendarPageName(){
        Wait.waitPlease(1);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        Wait.waitPlease(1);
        driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();

        String excpectedName =   driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Calendar Events')]")).getText();
        String actualName= "Calendar Events";
        Wait.waitPlease(1);
        Assert.assertEquals(actualName, excpectedName);

    }
}
