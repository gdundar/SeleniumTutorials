package my_practices.exercises.quickAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertMessage {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
    }

    @Test
    public void alertMessage(){

        driver.findElement(By.cssSelector("input[id='name']")).sendKeys("Hello");
        driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
        Actions act = new Actions(driver);

        driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
    }




    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
