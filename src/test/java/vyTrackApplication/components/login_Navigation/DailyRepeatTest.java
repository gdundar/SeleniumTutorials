package vyTrackApplication.components.login_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.vytrack.LoginPage;
import selenium.utilities.ConfigurationReader;
import selenium.utilities.Driver;
import vyTrackApplication.utilities.TestBase;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static vyTrackApplication.utilities.Driver.getDriver;

public class DailyRepeatTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    private WebDriver driver;

    @Test
    public void summary1() throws Exception {

        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.login(username, password);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))));

        Thread.sleep(3000);
        //click on Activities tab
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))));

        Thread.sleep(3000);
        //click on Calendar Events tab
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[14]")).click();

        Thread.sleep(3000);
        //click on create calendar event inner tab
        Driver.getDriver().findElement(By.cssSelector("a[title='Create Calendar event']")).click();

        Thread.sleep(3000);
        //click on repeat check box
        Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

        Thread.sleep(3000);
        //Daily is selected by default
        //Select s = new Select(Driver.getDriver().findElement(By.cssSelector("select[id='recurrence-repeats-view740']")));
        String actual = Driver.getDriver().findElement(By.cssSelector("select[class='recurrence-repeats__select']")).getAttribute("value");
        String expected = "daily";
        System.out.println(actual);
        Assert.assertEquals(actual, expected);

        //Verify day(s) checkbox is selected and default value is 1
        //get the value of the box
        String actualDays = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).getAttribute("value");
        String expectedDays = "1";
        System.out.println(actualDays);
        Assert.assertEquals(actualDays, expectedDays);

        Thread.sleep(3000);
        //Verify summary says Daily every 1 day
        //get the text of the summary
        String expectedDaily = Driver.getDriver().findElement(By.xpath("//*[text()='Daily every 1 day']")).getText();
        String actualDaily = "Daily every 1 day";
        System.out.println(expectedDaily);
        Assert.assertEquals(actualDaily, expectedDaily);

        //Check the weekday checkbox
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[2]")).click();

        //Verify that days input now disabled
        Boolean bool = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).isEnabled();
        System.out.println("is supposed to be false and it is: " + bool);

        //Verify summary says Daily every weekday
        String expectedWeekday = Driver.getDriver().findElement(By.xpath("//*[text()='Daily, every weekday']")).getText();
        String actualWeekday = "Daily, every weekday";
        System.out.println(expectedWeekday);
        Assert.assertEquals(expectedWeekday, actualWeekday);

    }

    //2) Daily repeat option, Repeat every, default values --- is already done above

    @Test
    public void errorMessage3() throws Exception {

        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.login(username, password);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))));

        Thread.sleep(3000);
        //click on Activities tab
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))));

        Thread.sleep(3000);
        //click on Calendar Events tab
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[14]")).click();

        Thread.sleep(3000);
        //click on create calendar event inner tab
        Driver.getDriver().findElement(By.cssSelector("a[title='Create Calendar event']")).click();

        Thread.sleep(3000);
        //click on repeat check box
        Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

        //Test the day(s) input entering different values (boundary value analysis)
        //sending number lower than 1
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).sendKeys(Keys.BACK_SPACE + "0");
        Driver.getDriver().findElement(By.xpath("//div[@class='btn-group pull-right']")).click();
        String actualError = Driver.getDriver().findElement(By.xpath("//*[text()='The value have not to be less than 1.']")).getText();
        String expectedError = "The value have not to be less than 1.";
        System.out.println(actualError);
        Assert.assertEquals(actualError, expectedError);


        //cancel the event
        Driver.getDriver().findElement(By.xpath("//a[@title='Cancel']")).click();

        Thread.sleep(3000);
        //click on create calendar event inner tab
        Driver.getDriver().findElement(By.cssSelector("a[title='Create Calendar event']")).click();

        Thread.sleep(3000);
        //click on repeat check box
        Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();


        //sending number higher than 99
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).sendKeys(Keys.BACK_SPACE + "100");
        Driver.getDriver().findElement(By.xpath("//div[@class='btn-group pull-right']")).click();
        String actualError2 = Driver.getDriver().findElement(By.xpath("//*[text()='The value have not to be more than 99.']")).getText();
        String expectedError2 = "The value have not to be more than 99.";
        System.out.println(actualError2);
        Assert.assertEquals(actualError2, expectedError2);
    }


    @Test
    public void functionality4() throws Exception {

        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.login(username, password);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))));

        Thread.sleep(3000);
        //click on Activities tab
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))));

        Thread.sleep(3000);
        //click on Calendar Events tab
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[14]")).click();

        Thread.sleep(3000);
        //click on create calendar event inner tab
        Driver.getDriver().findElement(By.cssSelector("a[title='Create Calendar event']")).click();

        Thread.sleep(3000);
        //click on repeat check box
        Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();


        //sending random number
        Random random = new Random();
        int num = (int)(Math.random() *100);
        String mun = ""+num+"";
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).sendKeys(Keys.BACK_SPACE + mun);
        Driver.getDriver().findElement(By.xpath("//*[text()='Summary:']")).click();


        Thread.sleep(3000);
        //Verify summary says Daily every 1 day
        //get the text of the summary
        String expectedDaily = Driver.getDriver().findElement(By.xpath("//*[text()='Daily every " + num + " days']")).getText();
        //the case will give 'day' if 1 is entered So the condition should be updated with if condition
        String actualDaily = "Daily every " + num +" days";
        System.out.println(expectedDaily);
        Assert.assertEquals(actualDaily, expectedDaily);
    }

    @Test//Could not validate the test - the results are not true and valid
    public void blankFields5() throws Exception {

        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.login(username, password);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))));

        Thread.sleep(3000);
        //click on Activities tab
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]")).click();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[5]"))));

        Thread.sleep(3000);
        //click on Calendar Events tab
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[14]")).click();

        Thread.sleep(3000);
        //click on create calendar event inner tab
        Driver.getDriver().findElement(By.cssSelector("a[title='Create Calendar event']")).click();

        Thread.sleep(3000);
        //click on repeat check box
        Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

        //Test the day(s) input entering different values (boundary value analysis)
        //clear the box
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).clear();
        System.out.println(Driver.getDriver().findElement(By.xpath("//*[text()='This value should not be blank.']")).isDisplayed());


        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[1]")).click();

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).sendKeys("3");
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='This value should not be blank.']")).isDisplayed());
            System.out.println("Visible!");
        }catch(Exception e){
            System.out.println("Not Visible!");
        }

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[1]")).click();

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).clear();
        System.out.println(Driver.getDriver().findElement(By.xpath("//*[text()='This value should not be blank.']")).isDisplayed());

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[1]")).click();

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).sendKeys("3");
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='This value should not be blank.']")).isDisplayed());
            System.out.println("Visible!");
        }catch(Exception e){
            System.out.println("Not Visible!");
        }

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[1]")).click();

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).clear();
        System.out.println(Driver.getDriver().findElement(By.xpath("//*[text()='This value should not be blank.']")).isDisplayed());

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("(//input[@type='radio'])[1]")).click();

        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]")).sendKeys("3");
        try {
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='This value should not be blank.']")).isDisplayed());
            System.out.println("Visible!");
        }catch(Exception e){
            System.out.println("Not Visible!");
        }
    }

    //Other tests are 6 and 7 --- pretty much same thing

}
