package my_practices.exercises.quickAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownButtons {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
    }

    @Test
    public void dropDownButtons() throws Exception{

        int num = driver.findElements(By.xpath("//option[contains(@value,'option')]")).size();
        System.out.println(num);

        //SELECT locator will be coming from THE select segment and their attributes!!!
        Select s = new Select(driver.findElement(By.xpath("//select[contains(@name,'dropdown-class-example')]")));
        Thread.sleep(3);
        s.selectByVisibleText("Option1");
        Thread.sleep(3);
        s.selectByIndex(2);
        Thread.sleep(3);
        s.selectByValue("option2");

        boolean b1 = driver.findElement(By.xpath("//option[contains(@value,'option1')]")).isDisplayed();
        boolean b2 = driver.findElement(By.xpath("//option[contains(@value,'option1')]")).isSelected();
        boolean b3 = driver.findElement(By.xpath("//option[contains(@value,'option1')]")).isEnabled();

        s.selectByVisibleText("Option1");

        boolean b4 = driver.findElement(By.xpath("//option[contains(@value,'option1')]")).isDisplayed();
        boolean b5 = driver.findElement(By.xpath("//option[contains(@value,'option1')]")).isSelected();
        boolean b6 = driver.findElement(By.xpath("//option[contains(@value,'option1')]")).isEnabled();

        System.out.println(b1 + " " + b2 + " " + b3  + " " +b4 + " " + b5 + " " + b6);

    }




    @AfterClass
    public void tearDown(){
        driver.close();
    }

}