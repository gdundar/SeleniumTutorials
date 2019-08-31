package my_practices.exercises.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VyTrackShortcutFunctionality {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {

        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        Thread.sleep(3000);

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager109");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(3000);

        driver.findElement(By.className("fa-share-square")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("See full list")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/opportunity']")).click();

        String text = driver.findElement(By.linkText("Shortcut Actions List")).getText();

        if (text.equals("Shortcut Actions List")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.findElement(By.linkText("Vehicle Services Logs")).click();

        String text3 = driver.findElement(By.linkText("You do not have permission to perform this action.")).getText();

        if (text3.equals("You do not have permission to perform this action")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.close();

    }

}
