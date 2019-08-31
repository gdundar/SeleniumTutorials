package my_practices.exercises.quickAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxes {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
    }

    @Test
    public void checkBox(){
        //two ways of finding numbers of checkboxes : 1
        int num = driver.findElements(By.cssSelector("input[name^='checkBoxOption']")).size();
        System.out.println(num);

        //two ways of finding numbers of checkboxes : 2
        List<WebElement> result = driver.findElements(By.cssSelector("input[name^='checkBoxOption']"));
        System.out.println(result.size());

        //we can use a for loop too
        for(WebElement outcome : result){
            System.out.println(outcome.getAttribute("name"));
        }

        boolean bool1 = driver.findElement(By.cssSelector("input[name^='checkBoxOption1']")).isDisplayed();
        boolean bool2 = driver.findElement(By.cssSelector("input[name^='checkBoxOption2']")).isSelected();
        boolean bool3 = driver.findElement(By.cssSelector("input[name^='checkBoxOption3']")).isEnabled();

        driver.findElement(By.cssSelector("input[name^='checkBoxOption1']")).click();

        boolean bool4 = driver.findElement(By.cssSelector("input[name^='checkBoxOption1']")).isDisplayed();
        boolean bool5 = driver.findElement(By.cssSelector("input[name^='checkBoxOption2']")).isSelected();
        boolean bool6 = driver.findElement(By.cssSelector("input[name^='checkBoxOption3']")).isEnabled();

        System.out.println(bool1 + " " + bool2 + " " + bool3 + " " + bool4 + " " + bool5 + " " + bool6);

    }



    @AfterClass
    public void tearDown(){
        driver.close();
    }



}
