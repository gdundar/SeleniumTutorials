package my_practices.exercises.quickAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtons {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
    }


    @Test
    public void longVersion(){

        //long version - THIS code will be repeated 3 more times all for 3 buttons!!!
        Boolean b1= driver.findElement(By.cssSelector("label[for='radio1']")).isSelected();
        Boolean b2 = driver.findElement(By.cssSelector("label[for='radio1']")).isDisplayed();
        Boolean b3 = driver.findElement(By.cssSelector("label[for='radio1']")).isEnabled();

        System.out.println(b1 + " " + b2 + " " + b3);

        driver.findElement(By.cssSelector("input[value='radio1']")).click();
        Boolean b4= driver.findElement(By.cssSelector("label[for='radio1']")).isSelected();
        Boolean b5 = driver.findElement(By.cssSelector("label[for='radio1']")).isDisplayed();
        Boolean b6 = driver.findElement(By.cssSelector("label[for='radio1']")).isEnabled();

        System.out.println(b4 + " " + b5 + " " + b6);

        int  num = driver.findElements(By.cssSelector("input[name='radioButton']")).size();
        System.out.println(num);

        for (int i=0; i< num; i++){
            driver.findElements(By.cssSelector("input[name='radioButton']")).get(i).click();
            System.out.println(driver.findElements(By.cssSelector("input[name='radioButton']")).get(i).getAttribute("value"));
        }
    }

    //Some EXTRA code
    public String radioButton(String locator){

        //button is not selected!!!
        Boolean b1= driver.findElement(By.cssSelector(locator)).isSelected();
        Boolean b2 = driver.findElement(By.cssSelector(locator)).isDisplayed();
        Boolean b3 = driver.findElement(By.cssSelector(locator)).isEnabled();

        System.out.println(b1 + " " + b2 + " " + b3);

        driver.findElement(By.cssSelector(locator)).click();

        Boolean b4= driver.findElement(By.cssSelector(locator)).isSelected();
        Boolean b5 = driver.findElement(By.cssSelector(locator)).isDisplayed();
        Boolean b6 = driver.findElement(By.cssSelector(locator)).isEnabled();

        System.out.println(b4 + " " + b5 + " " + b6);

        return locator;
    }


    @Test
    public void shortVersion(){

        //calling the method
        radioButton("input[value='radio1']");
        radioButton("input[value='radio2']");
        radioButton("input[value='radio3']");

        int  num = driver.findElements(By.cssSelector("input[name='radioButton']")).size();
        System.out.println(num);

        for (int i=0; i< num; i++){
            driver.findElements(By.cssSelector("input[name='radioButton']")).get(i).click(); // NO need to click to be able to get the "value"
            System.out.println(driver.findElements(By.cssSelector("input[name='radioButton']")).get(i).getAttribute("value"));
        }
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }



}
