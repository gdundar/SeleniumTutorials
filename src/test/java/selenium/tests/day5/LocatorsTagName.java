package selenium.tests.day5;

import my_practices.exercises.locators.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsTagName {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{

    test1();


    }

    public static void test1() throws Exception{
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println(buttons.size() + " is the number of buttons");
        for(WebElement button : buttons){
            button.click();
            System.out.println(button.getText());
            Thread.sleep(1000);

        }

        driver.close();

    }

}
