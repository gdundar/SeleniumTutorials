package selenium.onlineTeamActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCybtk {

    public static void main(String[] args) throws  Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

        String confirmation = driver.findElement(By.id("flash-messages")).getText();

        System.out.println(confirmation);

        Thread.sleep(3000);
        if(confirmation.equals("You logged into a secure area!\n×")){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }

        driver.close();

    }
}
