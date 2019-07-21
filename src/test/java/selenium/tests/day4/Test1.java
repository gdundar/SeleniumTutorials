package selenium.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //webelement is NOT required to create, we can user driver,getelement instead

        WebElement emailInputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit"));
        emailInputBox.sendKeys("email@gmail.com");
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);

        //finding the confirmation message after clicking:
        WebElement confirmation = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmation.getText();

        //verifying the message
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected message: " + expectedMessage);
            System.out.println("Actual message: " + actualMessage);
        }

        driver.close();




    }

}
