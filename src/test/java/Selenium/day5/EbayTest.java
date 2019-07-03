package Selenium.day5;

import Selenium.Exercises.BrowserFactory;
import Selenium.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EbayTest {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws  Exception{

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("Java books", Keys.ENTER);
        //driver.findElement(By.id("gh-ac")).click();
        driver.findElement(By.xpath("//img[@alt='[P..D..F] Head First Java -2nd edition p.d.f version B00k']")).click();
        //driver.findElement(By.partialLinkText("Head")).click();
        driver.findElement(By.id("atcRedesignId_btn")).click();
        Thread.sleep(3000);

        driver.navigate().to("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("Mackbook", Keys.ENTER);
        driver.findElement(By.xpath("//img[@alt= 'Apple MacBook Pro 13 / Core i5 / UPGRADE UPTO 2TB SSD  & 16 GB RAM / OS-2017 ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@i='-99']")).click();

        String actual = driver.findElement(By.xpath("//div[@class='vi-bbox-dspn u-flL lable binLable']")).getText();
        String expected = "Price:";

        SeleniumUtils.verifyEquals(expected, actual);

        Thread.sleep(6000);
        driver.quit();



    }


}
