package Selenium.day5;

import Selenium.Exercises.BrowserFactory;
import Selenium.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LocatorIDs {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        test2();
        test1();

    }

    public static void test2() throws InterruptedException {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");

        driver.findElement(By.partialLinkText("Drag")).click();

    }

    public static void test1() throws InterruptedException {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");


        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        SeleniumUtils.verifyEquals(expected, actual);
        driver.findElement(By.linkText("Logout")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
