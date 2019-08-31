package selenium.tests.day6;

import my_practices.exercises.locators.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Amazon {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws Exception{

        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone");
        driver.findElement(By.className("nav-input")).click();
        Thread.sleep(3000);
        String title =  driver.getTitle();

        if(title.contains("Iphone")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();

    }
}
