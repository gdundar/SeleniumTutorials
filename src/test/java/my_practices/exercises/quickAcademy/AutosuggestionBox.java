package my_practices.exercises.quickAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutosuggestionBox {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
    }

    @Test
    public void test(){
        driver.findElement(By.xpath("(//input[@id='autocomplete'])")).sendKeys("United");
        driver.findElement(By.xpath("(//input[@id='autocomplete'])")).sendKeys(Keys.DOWN);
        String str = (driver.findElement(By.xpath("(//input[@id='autocomplete'])")).getText());
        System.out.println(str);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"autocomplete\").value;";
        String result = (String) js.executeScript(script);
        System.out.println(result);

        while(! str.contains("United")) {
            driver.findElement(By.xpath("(//input[@id='autocomplete'])")).sendKeys(Keys.DOWN);
            break;
        }

        String result2 = (String) js.executeScript(script);
        System.out.println(result2);
        System.out.println(result2);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }




}
