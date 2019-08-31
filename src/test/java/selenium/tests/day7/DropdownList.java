package selenium.tests.day7;

import my_practices.exercises.locators.BrowserFactory;
import selenium.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownList {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openDropDownPage();
        SeleniumUtils.waitPlease(2);
        test1();
        SeleniumUtils.waitPlease(2);
        test2();
        SeleniumUtils.waitPlease(2);
        driver.close();


    }

    public static void openDropDownPage(){
        //going to the page
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement element= driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtils.verifyIsDisplayed(element);


    }
    public static  void verifyIsDisplayed(WebElement element){

        if(element.isDisplayed()){
            System.out.println("Passed");
            System.out.println(element.getText() + " : is visible");
        }else {
            System.out.println("Failed");
            System.out.println(element.getText() + " : is not visible");
        }

    }
    public static void test1(){
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        //to work with select elements
        //we need to use Select class
        Select dropdownSelect = new Select(dropdown1);
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        String expcted = "Please select an option";
        SeleniumUtils.verifyEquals(expcted, actual);

        List<WebElement> option = dropdownSelect.getOptions();
        for(WebElement options : option){
            System.out.println(options);
        }
    }

    public static void test2(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        List<WebElement> states = dropDownSelect.getOptions();
        for (WebElement element: states){
            System.out.println(element.getText());
        }
        dropDownSelect.selectByVisibleText("Texas");
    }

    public static void test3() {
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        List<WebElement> states = dropDownSelect.getOptions();
    }

}
