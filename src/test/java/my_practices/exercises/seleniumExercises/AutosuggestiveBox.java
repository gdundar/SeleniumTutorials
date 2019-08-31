package my_practices.exercises.seleniumExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutosuggestiveBox {
    WebDriver driver;

    @BeforeClass
    public void setuo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://ksrtc.in/oprs-web/guest/home.do");
    }

    @Test
    public void AutoIndianBox(){

        driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("fromPlaceName")).getText());

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"fromPlaceName\").value;";
        String result = (String) js.executeScript(script);
        System.out.println(result);

    }

/*
ID, CSS, TagName, xpath
 */


    @AfterClass
    public void tearDown(){

        driver.close();

    }
}
