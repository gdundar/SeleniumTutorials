package selenium.exercises.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://myaccount.google.com/intro");
        driver.findElement(By.className("WpHeLc")).click();

        WebElement userName = driver.findElement(By.id("identifierId"));
        userName.sendKeys("hpschemistry@gmail.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.navigate().to("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("selenium tutorials");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.name("btnK")).click();



        driver.navigate().to("https://login.yahoo.com/");
        driver.findElement(By.cssSelector("#login-username")).sendKeys("selenium@yahoo.com");
        driver.findElement(By.xpath("//input[@id='login-signin']")).click();
       // driver.findElement(By.cssSelector("#login-signin")).click();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Trouble signing in?")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }
}
