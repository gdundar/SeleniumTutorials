package selenium.teamActivity;

import selenium.exercises.locators.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BriteErpApp {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = BrowserFactory.getDriver("chrome");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.get("http://54.148.96.210/web/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //send user name
        driver.findElement(By.id("login")).sendKeys("eventsCRM_User@info.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //send password
        driver.findElement(By.id("password")).sendKeys("opJu56KKL39");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //click on submit button to log on the website
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
/*
TEST ONE
User will not be able to leave a log note on the calendar cells
1.The website environment should be ready
2.User should have  a valid username
3.User should have a valid working password

?* HOW I would click one of the item RANDOMLY?
 */

    @Test
    public void negativeTest(){

        //click on the EVENT tab
        driver.findElement(By.xpath("//a[@data-menu-xmlid='event.event_main_menu']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //click on the CALANDER VIEW
        driver.findElement(By.cssSelector("button[aria-label=\"calendar\"]")).click();//click on the very left EVENT CATEGORY
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //clickable item ?
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/table/tbody/tr/td/div[2]/div/div[2]/table/tbody/tr[9]/td[2]")).sendKeys("Meeting");
        //How to say it is NOT clickable????
    }

    /*
    TEST TWO
    User will be able to SUBSCRIBE to the event updates
    1.The website environment should be ready
    2.User should have  a valid username
    3.User should have a valid working password
     */
    @Test
    public void positiveTest() throws Exception{
        //click on the EVENT tab
        driver.findElement(By.xpath("//a[@data-menu-xmlid='event.event_main_menu']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        Thread.sleep(3);
        //click on the created event tag
        driver.findElement(By.cssSelector("button[accesskey='l']")).click();
        //click on the Event
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]")).click();
        //click on the UNPUBLISHED tab
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[text()='On Website']")).click();

        //click on SUBSCRIBE button
        Thread.sleep(3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[class='btn btn-primary js_follow_btn']")).click();



        //FAILING STAGE!!!!
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(3);
        //driver.findElement(By.cssSelector("button[class='btn btn-default js_unfollow_btn hidden']")).click();
        String expectedMessage = driver.findElement(By.xpath("//button[@href='#'][2]")).getText();
        System.out.println("The expected message: " + expectedMessage);
        String actualMessage = "Subscribe";

        Assert.assertEquals(expectedMessage, actualMessage);
       
    }

}
