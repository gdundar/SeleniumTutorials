package selenium.onlineTeamActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class ExpectedRevenue_CRM {
    static WebDriver driver;

    static String userName = "eventscrmmanager10@info.com";
    static String password =  "eventscrmmanager";
    static String actual;


    @BeforeMethod
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/");
        driver.findElement(By.cssSelector("a[href='/web/login']")).click();
        driver.findElement(By.id("login")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @AfterMethod
    public static void tearDownd(){

        driver.close();
    }

    @Test
    public void pivot()throws Exception{

        Thread.sleep(3000);
        //click - CRM tab
        driver.findElement(By.cssSelector("a[data-menu='261']")).click();
        Thread.sleep(3000);
        //click pivot view
        driver.findElement(By.cssSelector("button[aria-label='pivot']")).click();
        Thread.sleep(3000);
        //click on total and secondly double click
        driver.findElement(By.xpath("//table/tbody/tr/td")).click();
        driver.findElement(By.xpath("//table/tbody/tr/td")).click();
        Thread.sleep(3000);
        //click on opportunity
        driver.findElement(By.xpath("(//*[text()='Opportunity'])[2]")).click();

        //get the macbook price from pivot
        Thread.sleep(3000);
        String revenuePivot = (driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]")).getText());
        System.out.println(revenuePivot);

        Thread.sleep(3000);
        //click - LIST VIEW
        driver.findElement(By.cssSelector("button[accesskey='l']")).click();

       //search for Mac Book and get the price
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Search...']")).sendKeys("MacBook Pro");
        driver.findElement(By.cssSelector("input[placeholder='Search...']")).sendKeys(Keys.ENTER);

        //get teh price of the MacBook pro
        String macBookListPrice = driver.findElement(By.xpath("//table//tbody//tr//td[9]")).getText();
        System.out.println(macBookListPrice);

        Assert.assertEquals(revenuePivot, macBookListPrice);

    }


    @Test
    public void pivotSubTotal()throws Exception{

        Thread.sleep(3000);
        //click - CRM tab
        driver.findElement(By.cssSelector("a[data-menu='261']")).click();
        Thread.sleep(3000);
        //click pivot view
        driver.findElement(By.cssSelector("button[aria-label='pivot']")).click();
        Thread.sleep(3000);
        //click on total and secondly double click
        driver.findElement(By.xpath("//table/tbody/tr/td")).click();
        driver.findElement(By.xpath("//table/tbody/tr/td")).click();
        Thread.sleep(3000);
        //click on opportunity
        driver.findElement(By.xpath("(//*[text()='Opportunity'])[2]")).click();

        //get the macbook price from pivot
        Thread.sleep(3000);
        String totalrevenuePivot = (driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText()).replace(".", "").replace(",", "");

        String revenuePivot2 = (driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText()).replace(".", "").replace(",", "");
        String revenuePivot3 = (driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText()).replace(".", "").replace(",", "");
        String revenuePivot4 = (driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]")).getText()).replace(".", "").replace(",", "");
        String revenuePivot5 = (driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText()).replace(".", "").replace(",", "");
        String revenuePivot6 = (driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]")).getText()).replace(".", "").replace(",", "");
        String revenuePivot7 = (driver.findElement(By.xpath("//table/tbody/tr[7]/td[2]")).getText()).replace(".", "").replace(",", "");


        Integer trp = Integer.parseInt(totalrevenuePivot);
        System.out.println(totalrevenuePivot);

        Integer rp2 = Integer.parseInt(revenuePivot2);
        Integer rp3 = Integer.parseInt(revenuePivot3);
        Integer rp4 = Integer.parseInt(revenuePivot4);
        Integer rp5 = Integer.parseInt(revenuePivot5);
        Integer rp6 = Integer.parseInt(revenuePivot6);
        Integer rp7 = Integer.parseInt(revenuePivot7);

        Integer total = rp2 + rp3 + rp4 + rp5 + rp6 + rp7;
        System.out.println(total);

        Assert.assertEquals(totalrevenuePivot, total);

    }



}
