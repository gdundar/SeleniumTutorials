package selenium.onlineTeamActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BriteERP_CRM {
    static WebDriver driver;

    static String userName = "eventscrmmanager10@info.com";
    static String password =  "eventscrmmanager";
    static String actual;


    @BeforeMethod
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/");
        driver.findElement(By.cssSelector("a[href='/web/login']")).click();
        driver.findElement(By.id("login")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @AfterMethod
    public static void tearDownd(){

        driver.quit();
    }


    @Test(priority = 1)
    public static void createItem() throws Exception{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click - CRM tab
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[data-menu='261']")).click();
        Thread.sleep(3000);

        //click - LIST VIEW
        driver.findElement(By.cssSelector("button[accesskey='l']")).click();
        Thread.sleep(3000);

        //search for the item in the search box
        driver.findElement(By.cssSelector("input[placeholder='Search...']")).sendKeys("Spartan");
        Thread.sleep(3000);
        //click on the searched item - Spartan
        //NO need to click
        //driver.findElement(By.cssSelector("input[placeholder='Search...']")).click();
        //click ENTER
        driver.findElement(By.cssSelector("input[placeholder='Search...']")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        //Get the number of item before deleted
        actual  = driver.findElement(By.cssSelector("span[class='o_pager_limit']")).getText();

        Thread.sleep(3000);
        //click on the check box
        driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
        Thread.sleep(3000);
        //click on the action button
        driver.findElement(By.xpath("(//button[@aria-expanded='false'])[2]")).click();
        Thread.sleep(3000);
        //click on delete button
        Thread.sleep(3000); driver.findElement(By.xpath("(//a[@data-section='other'])[4]")).click();
        //confirm to delete
        driver.findElement(By.xpath("(//button[@type='button'])[23]")).click();
    }


    @Test(priority = 2)
    public static void confirmDeletedItem() throws Exception{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click - CRM tab
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[data-menu='261']")).click();
        Thread.sleep(3000);

        //click - LIST VIEW
        driver.findElement(By.cssSelector("button[accesskey='l']")).click();
        Thread.sleep(3000);

        //get the number of item after deleted
        String expected = driver.findElement(By.cssSelector("span[class='o_pager_limit']")).getText();

        Integer e = Integer.parseInt(expected);
        Integer a = Integer.parseInt(actual);
        Integer result = (a-e);

        if(result == 1) {
            System.out.println("We got it right \nThe number of items before and after deleting is : " + (a - e));
        }
        //Another version could be : Search for Spartan and if there is no Spartan then return true

    }

}
