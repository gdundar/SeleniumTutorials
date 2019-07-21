package selenium.tests.day13_Actions;

import selenium.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTests {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void jsExecuterTest1(){
        driver.get("http://practice.cybertekschool.com/");
        //No object can be created from interface so NO new for java script
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String title = (String)js.executeScript("return document.title");
        System.out.println(title);

        js.executeScript("alert('HELLO SPARTANS!!!')");
        System.out.println(driver.switchTo().alert().getText());
        SeleniumUtils.waitPlease(5);

        Alert alert = driver.switchTo().alert();
        alert.accept();


    }

    @Test
    public void scroolTest1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for (int i=0; i < 10; i++) {
            js.executeScript("window.scroll(0, 250)");

        }
    }
    @Test
    public void scroolTest2(){
        driver.get("http://practice.cybertekschool.com");
        WebElement footerLink = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].scrollIntoView(true)", footerLink);
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].click()", footerLink);
        SeleniumUtils.waitPlease(2);
    }

    @AfterMethod
    public void tearDownd(){
        driver.quit();
    }


}
