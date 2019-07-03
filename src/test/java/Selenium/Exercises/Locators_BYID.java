package Selenium.Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Locators_BYID {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://google.com");

        WebElement symbol = driver.findElement(By.id("gbqfbb"));
        symbol.click();

        Thread.sleep(3000);

        String actual = symbol.getAttribute("I'm Feeling Lucky");
        String expected = "I'm Feeling Lucky";

        if(expected.equals("I'm Feeling Lucky")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.close();
    }
}
