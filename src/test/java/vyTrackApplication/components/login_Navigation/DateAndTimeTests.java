package vyTrackApplication.components.login_Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import java.util.concurrent.TimeUnit;

import static vyTrackApplication.utilities.BrowserUtils.waitForPageToLoad;

public class DateAndTimeTests extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void endDateAutoAdjust() throws Exception {

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
        //Today`s date
        String startToday = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]")).getAttribute("value");
        String endToday = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[2]")).getAttribute("value");

        //click on Start date
        Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]")).click();

        //click on the future day which is the 31st
        Driver.getDriver().findElement(By.xpath("//a[text()='31']")).click();

        Thread.sleep(3000);

        //Today`s date
        String startFuture = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]")).getAttribute("value");
        String endFuture = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[2]")).getAttribute("value");

        Assert.assertEquals(startFuture, endFuture);
        System.out.println(startFuture + " - " + endFuture);
        Assert.assertEquals(startToday, endToday);
        System.out.println(startToday + " - " + endToday);

    }

    @Test
    public void endTimeAutoAdjust() throws Exception {

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
        //click on time
        Driver.getDriver().findElement(By.xpath("(//input[@placeholder='time'])[1]")).click();

        Thread.sleep(3000);
        //click on the time 8: 00 AM
        Driver.getDriver().findElement(By.xpath("(//li[@class='ui-timepicker-am'])[17]")).click();

        //date attributes
        Thread.sleep(3000);
        String startTime = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='time'])[1]")).getAttribute("value");
        String endTime = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='time'])[2]")).getAttribute("value");

        System.out.println(startTime + " - " + endTime);

        //getting only the numbers
        String resultST = "";
        for (int i = 0; i < 7; i++) {
            if (startTime.charAt(i) == '0' || startTime.charAt(i) == '1' || startTime.charAt(i) == '2' || startTime.charAt(i) == '3'
                    || startTime.charAt(i) == '4' || startTime.charAt(i) == '5' || startTime.charAt(i) == '6' || startTime.charAt(i) == '7'
                    || startTime.charAt(i) == '8' || startTime.charAt(i) == '9') {
                resultST += startTime.charAt(i);
            }
        }
        System.out.println(resultST);

        //getting only the numbers
        String resultET = "";
        for (int i = 0; i < 7; i++) {
            if (endTime.charAt(i) == '0' || endTime.charAt(i) == '1' || endTime.charAt(i) == '2' || endTime.charAt(i) == '3'
                    || endTime.charAt(i) == '4' || endTime.charAt(i) == '5' || endTime.charAt(i) == '6' || endTime.charAt(i) == '7'
                    || endTime.charAt(i) == '8' || endTime.charAt(i) == '9') {
                resultET += endTime.charAt(i);
            }
        }
        System.out.println(resultET);

        //parseInt to see the difference
        Integer sTime = Integer.parseInt(resultST);
        Integer eTime = Integer.parseInt(resultET);
        Integer difference = eTime - sTime;
        //the difference between two hours will give 100 all times EX: 10:00 AM and 9:00 AM 1000 - 900 = 100
        Integer one = 100;
        Assert.assertEquals(difference, one);

    }


    @Test
    public void dateTimeAutoAdjust() throws Exception {

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
        //click on time
        Driver.getDriver().findElement(By.xpath("(//input[@placeholder='time'])[1]")).click();

        Thread.sleep(3000);
        //click on the time 11: 30 PM  [24] is picked since the name of the variables change when one is selected
        Driver.getDriver().findElement(By.xpath("(//li[@class='ui-timepicker-pm'])[24]")).click();

        //get attribute of the dates
        Thread.sleep(3000);
        String startTime = Driver.getDriver().findElement(By.xpath("(//li[@class='ui-timepicker-pm'])[23]")).getAttribute("value");
        String endTime = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='time'])[2]")).getAttribute("value");

        //write the date attributes
        System.out.println(startTime + " - " + endTime);

        Thread.sleep(3000);
        //Today`s date
        String startToday = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]")).getAttribute("value");
        String endToday = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[2]")).getAttribute("value");

        System.out.println(startToday + " " + endToday);

        //the day is picked as numbers from Jul 26, 2019 Jul 27, 2019 ---> 27 and 26 is extracted
        String sToday = startToday.substring(4,6);
        String eToday = endToday.substring(4,6);

        //parseInt to integers to see the difference
        Integer sT = Integer.parseInt(sToday);
        Integer eT = Integer.parseInt(eToday);

        //one day diffference should be 1
        Integer diff = eT - sT;
        Integer one = 1;
        Assert.assertEquals(diff, one);

    }

}
