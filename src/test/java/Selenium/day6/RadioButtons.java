package Selenium.day6;

import Selenium.Exercises.BrowserFactory;
import Selenium.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtons {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openRadioButtonPage();
        test1();
        test2();
        test3();
        test4();
        driver.close();

    }

    public static  void openRadioButtonPage(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    public static void test1(){

        WebElement blueBtn = driver.findElement(By.id("blue"));
        if(blueBtn.isSelected()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        SeleniumUtils.waitPlease(2);
    }

    public static void test2(){
        WebElement blackBtn =   driver.findElement(By.id("black"));
        WebElement greenkBtn =   driver.findElement(By.id("green"));

        if(blackBtn.isEnabled() && (!greenkBtn.isEnabled())){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
    }

    public static void test3(){
        WebElement blackBtn = driver.findElement(By.id("black"));
        WebElement blueBtn = driver.findElement(By.id("green"));

        if(blueBtn.isSelected()){
            System.out.println("Passed");
            System.out.println("Blue is selected");
        }else{
            System.out.println("Failed");
            System.out.println("Blue is NOT selected");
        }

        blackBtn.click();

        if(blackBtn.isSelected()){
            System.out.println("Passed");
            System.out.println("Black is selected");
        }else{
            System.out.println("Failed");
            System.out.println("Black is NOT selected");
        }

        if(!blackBtn.isSelected()){
            System.out.println("Passed");
            System.out.println("Black is Not selected");
        }else{
            System.out.println("Failed");
            System.out.println("Black is selected");
        }

        SeleniumUtils.waitPlease(2);
    }

    public  static  void test4(){
        List<WebElement> listOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        int counter =0;
        for(WebElement radioBttn : listOfRadioButtons){
            if(radioBttn.isSelected()){
                counter++;
                System.out.println(radioBttn.getAttribute("id"));
            }
        }
        System.out.println(counter);
    }
}
