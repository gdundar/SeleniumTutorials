package vyTrackApplication.components.login_Navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vyTrackApplication.utilities.Wait;

import java.util.concurrent.TimeUnit;

public class PageAccessTest {

    WebDriver driver;
    String userName = "storemanager55";
    String password = "UserUser123";

    String salesUsername = "salesmanager109";
    String salesPassword = "UserUser123";

    String driverUN = "user9";
    String driverPW = "UserUser123";

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

    @Test
    public void verifyStoreManagerNameDisplayed(){

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
        Wait.waitPlease(5);

        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        Wait.waitPlease(1);
        driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();

        Wait.waitPlease(5);
        String expected = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        String actual = "All Vehicle Contract";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void salesManager(){
        //set the environment with driver, website and log in
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput")).sendKeys(salesUsername);
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys(salesPassword);
        Wait.waitPlease(1);
        driver.findElement(By.id("_submit")).click();
        Wait.waitPlease(1);

        Wait.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();

        Wait.waitPlease(5);
        String expected = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        String actual = "All Vehicle Contract";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void asdriver(){
        //set the environment with driver, website and log in
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput")).sendKeys(driverUN);
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys(driverPW);
        Wait.waitPlease(1);
        driver.findElement(By.id("_submit")).click();
        Wait.waitPlease(1);

        Wait.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Vehicle Contracts')]")).click();

        Wait.waitPlease(5);
        String expected = driver.findElement(By.xpath("//div[contains(text(),'You do not have permission to perform this action.')]")).getText();
        String actual = "You do not have permission to perform this action.";
        Assert.assertEquals(actual, expected);
    }
}
