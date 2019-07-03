package Selenium.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {
    public static void verifyEquals(String expectedResult, String actualResult ){
        if(expectedResult.equals(actualResult)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED!");
            System.out.println("The expected result: " + expectedResult);
            System.out.println("The actual result: " + actualResult);
        }
    }
    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void openPage(String page, WebDriver driver){
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));
        for(WebElement example : listOfExamples){
            if(example.getText().contains(page)){
                example.click();
                break;
            }
        }
    }
}
