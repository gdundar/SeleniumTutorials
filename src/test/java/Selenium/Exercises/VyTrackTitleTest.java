package Selenium.Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrackTitleTest {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {

        driver.get("http://qa2.vytrack.com/user/login");

        Thread.sleep(3000);

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager109");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(3000);
        String expected =  driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();

        driver.findElement(By.className("mobile-hide")).click();

        String actual = driver.findElement(By.id("page-title")).getText();

        if(actual.contains(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");

        }

        Thread.sleep(3000);
        driver.close();
    }
}
