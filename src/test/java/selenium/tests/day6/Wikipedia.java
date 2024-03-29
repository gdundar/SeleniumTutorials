package selenium.tests.day6;

import my_practices.exercises.locators.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wikipedia {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws Exception{

        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium Webdriver");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class='pure-button pure-button-primary-progressive']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='selenium (software)']")).click();
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();

        if(url.endsWith("x")){
            System.out.println("Passed!");
        }else{
            System.out.println("Failed!");
        }

        driver.close();


    }
}
