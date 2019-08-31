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

public class LoginTest {

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
        Wait.waitPlease(1);

        String name = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Kenton Ritchie')]")).getText();

        if(name.equals("Kenton Ritchie")){
            System.out.println("Name is: " + name + " matching");
        }else{
            System.out.println("Name is: " + name + " not matching");
        }
    }

    @Test
    public void dashboardVisible(){
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

        String expected = driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Dashboard')]")).getText();
        String actual = "Dashboard";
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

        String expected = driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Dashboard')]")).getText();
        String actual = "Dashboard";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void salesManagerNameDisplayed(){
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

        String expected = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Keenan Koch')]")).getText();
        String actual = "Keenan Koch";
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

        String expected = driver.findElement(By.xpath("//h1[@class='oro-subtitle'][contains(text(),'Quick Launchpad')]")).getText();
        String actual = "Quick Launchpad";
        Assert.assertEquals(actual, expected);

    }


    @Test
    public void driverNameDsiplayed(){
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

        String expected = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Cedrick Cummings')]")).getText();
        String actual = "Cedrick Cummings";
        Assert.assertEquals(actual, expected);

    }

    //The below two test cases are negative test cases

    @Test
    public void loginNegativeTestCase(){
        //set the environment with driver, website and log in
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput")).sendKeys("Hello");
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("World123");
        Wait.waitPlease(1);
        driver.findElement(By.id("_submit")).click();
        Wait.waitPlease(1);

        String expected = driver.findElement(By.xpath("//div[contains(text(),'Invalid user name or password.')]")).getText();
        String actual = "Invalid user name or password.";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void url(){
        //set the environment with driver, website and log in
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput")).sendKeys("Hello");
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("World123");
        Wait.waitPlease(1);
        driver.findElement(By.id("_submit")).click();
        Wait.waitPlease(1);

        String expected = driver.getCurrentUrl();
        String actual = "http://qa2.vytrack.com/user/login";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void pageTitle(){
        //set the environment with driver, website and log in
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput")).sendKeys("Hello");
        Wait.waitPlease(1);
        driver.findElement(By.id("prependedInput2")).sendKeys("World123");
        Wait.waitPlease(1);
        driver.findElement(By.id("_submit")).click();
        Wait.waitPlease(1);

        String expected = driver.getTitle();
        String actual = "Login";
        Assert.assertEquals(actual, expected);

    }

}
