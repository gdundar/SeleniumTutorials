package my_practices.exercises.quickAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload {
    WebDriver driver;

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String path = "/Users/yasinbekar/Downloads/Screen Shot 2019-07-21 at 4.57.57 PM.png";
        chooseFile.sendKeys(path);

        driver.findElement(By.id("file-submit")).click();
        Assert.assertTrue(driver.findElement(By.id("uploaded-files")).isDisplayed());
    }
}
