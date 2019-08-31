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

public class MenuOptions_StoreManager {
    WebDriver driver;
    String userName = "storemanager55";
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
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test//PAGE TITLE IS different in reality!!! check the webpage   WHY the second xpath does not have //?
    public void verifyDashboardTitle(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Dashboards')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("span[class='title title-level-2'][contains(text(),'Dashboard')]")).click();

        Wait.waitPlease(2);
        String expectedTitle = driver.getTitle();
        String actualTitle = "Dashboard - Dashboards";
        Wait.waitPlease(2);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test//passed
    public void verifyDashboardName(){
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        Wait.waitPlease(1);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")).click();

        Wait.waitPlease(1);
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Dashboard')]")).getText();
        String expectedName = "Dashboard";
        System.out.println(actualName);

        Assert.assertEquals(actualName, expectedName);
    }

    @Test//passed
    public void verifyVehicleTitle(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();

        Wait.waitPlease(2);
        String expectedTitle = driver.getTitle();
        String actualTitle = "All - Car - Entities - System - Car - Entities - System";
        Wait.waitPlease(2);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test//passed
    public void verifyVehicleName(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();

        Wait.waitPlease(10);
        String expectedTitle = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Wait.waitPlease(2);
        String actualTitle = "All Cars";
        Wait.waitPlease(2);
        System.out.println(expectedTitle);
        Wait.waitPlease(2);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test//failed since the titles were different in reality!!! ---> All - Accounts - Customers
    public void verifyAccountsTitle(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Accounts')]")).click();

        Wait.waitPlease(2);
        String expectedTitle = driver.getTitle();
        String actualTitle = "All - Contacts - Customers";
        Wait.waitPlease(2);
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test//failed
    public void verifyAccountsName(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Accounts')]")).click();

        Wait.waitPlease(2);
        String expectedName =  driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'All Contacts')]")).getText();
        String actualName = "All Contacts";
        Wait.waitPlease(2);
        Assert.assertEquals(actualName, expectedName);
    }

    @Test//passed
    public void verifyOpportunitiesTitle(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Sales')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Opportunities')]")).click();

        Wait.waitPlease(2);
        String expectedTitle = driver.getTitle();
        String actualTitle = "Open Opportunities - Opportunities - Sales";
        Wait.waitPlease(2);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test//passed
    public void verifyOpportunitiesName(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Sales')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Opportunities')]")).click();

        Wait.waitPlease(10);
        String actualName =   driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Open Opportunities')]")).getText();
        String expectedName = "Open Opportunities";
        Wait.waitPlease(2);
        Assert.assertEquals(actualName, expectedName);
    }


    @Test//passed
    public void verifyCallsTitle(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[contains(text(),'Calls')]")).click();

        Wait.waitPlease(2);
        String expectedTitle = driver.getTitle();
        String actualTitle = "All - Calls - Activities";
        Wait.waitPlease(2);
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test//failed
    public void verifyCallsName(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[contains(text(),'Calls')]")).click();

        Wait.waitPlease(2);
        String actualName =   driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'All Calls')]")).getText();
        String expectedName = "All Calls";
        Wait.waitPlease(2);
        Assert.assertEquals(actualName, expectedName);
    }

    @Test//failed since the titles were not the same as provided on the req.
    public void verifyCalendarEventsTitle(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();

        Wait.waitPlease(2);
        String expectedTitle = driver.getTitle();
        String actualTitle = "Calendar Events - Activities";
        Wait.waitPlease(2);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test//failed
    public void verifyCalendarEventsName(){
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        Wait.waitPlease(2);
        driver.findElement(By.xpath("//span[contains(text(),'Calendar Events')]")).click();

        Wait.waitPlease(2);
        String actualName =   driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'All Calendar Events')]")).getText();
        String expectedName = "All Calendar Events";
        Wait.waitPlease(2);
        Assert.assertEquals(actualName, expectedName);
    }

}
