package selenium.tests.day8_testng_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void setUp(){
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void test1(){
        int expectedYear = 2019;
        String expectedMonth = "July";
        int expectedDay = 7;

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        int actualYear = Integer.parseInt(selectYear.getFirstSelectedOption().getText());
        String actualMonth =  selectMonth.getFirstSelectedOption().getText();
        int actualDay = Integer.parseInt(selectDay.getFirstSelectedOption().getText());

        Assert.assertEquals(actualDay, expectedDay);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualYear, actualYear);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
