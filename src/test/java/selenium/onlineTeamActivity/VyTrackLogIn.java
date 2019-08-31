package selenium.onlineTeamActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrackLogIn {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://qa2.vytrack.com/user/login");

        Thread.sleep(3000);

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager109");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(3000);
        driver.findElement(By.className("dropdown-toggle")).click();
        Thread.sleep(3000);
        String confirmation = driver.findElement(By.className("oro-subtitle")).getText();
        System.out.println(confirmation);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/user/logout']")).click();

        Thread.sleep(3000);



        if(confirmation.equals("Dashboard")){
            System.out.println("Test Passed!");
        }else {
            System.out.println("Test Failed!");
        }

        driver.close();
    }
}
