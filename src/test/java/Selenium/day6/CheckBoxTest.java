package Selenium.day6;

import Selenium.Exercises.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTest {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        test1();
        driver.close();

    }
    public static void test1(){
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if(!checkBox1.isSelected()){
            System.out.println("Checkbox 1 is NOT selected");
        }else{
            System.out.println("Checkbox 1 is selected");
        }

        if(checkBox2.isSelected()){
            System.out.println("Checkbox 2 is selected");
        }else{
            System.out.println("Checkbox 2 is NOT selected");
        }
    }
}
