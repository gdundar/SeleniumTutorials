package my_practices.exercises.seleniumExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframeManagement {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
    }

    @Test
    public void iframe(){
        System.out.println(driver.findElement(By.tagName("iframe")).getSize());
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        driver.switchTo().frame(0);

        Actions act = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        /*
        click(), sendKeys(), doubleClick(), dragAndDrop()
         */

        act.dragAndDrop(source, target).perform();

        driver.switchTo().defaultContent();

    }




    @AfterClass
    public void tearDown(){

        driver.close();

    }
}
