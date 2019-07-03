package Selenium.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class Test2 {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //webelement is NOT required to create, we can user driver,getelement instead

        WebElement emailInputBox = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.id("form_submit"));

        Faker faker = new Faker();
        String name = faker.pokemon().name().replace(" ", "").toLowerCase();
        Thread.sleep(3000);

        emailInputBox.sendKeys(faker.internet().emailAddress());

        Thread.sleep(3000);
        emailInputBox.clear();
        Thread.sleep(3000);

        //emailInputBox.sendKeys("email@gmail.com" + Keys.ENTER);

        emailInputBox.sendKeys(name + "@gmail.com" + Keys.ENTER);

        Thread.sleep(3000);
        driver.close();


    }

}
