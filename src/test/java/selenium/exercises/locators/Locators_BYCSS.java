package selenium.exercises.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Locators_BYCSS {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Jason");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Backer");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("JasBac");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("j_backer@gmail.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("1234567890jb");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("0536-664-4545");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/23/1984");
        driver.findElement(By.cssSelector("option[value='DE']")).click();
        Select select = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select.selectByVisibleText("SDET");

        driver.findElement(By.cssSelector("input[id='inlineCheckbox2']")).click();

        driver.findElement(By.cssSelector("button[id='wooden_spoon']")).click();


    }
}
