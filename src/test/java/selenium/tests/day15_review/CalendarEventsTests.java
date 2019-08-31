package selenium.tests.day15_review;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.vytrack.CalendarEventsPage;
import selenium.utilities.ConfigurationReader;
import selenium.utilities.TestBase;
import selenium.utilities.VyTrackUtils;

import java.util.Arrays;
import java.util.List;

public class CalendarEventsTests extends TestBase {
    //BeforeMethod is coming from TestBase
    CalendarEventsPage calendarPage = new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions(){
        //we are reading username from .properties file
        String username = ConfigurationReader.getProperty("storemanagerusername");
        //we are reading password from .properties file
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        VyTrackUtils.login(driver, username, password); //login

        //go to Calendar Events
        VyTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        //since vytrack displays overlay screen during loading of the page
        //we have wait, until that overlay screen disappear
//        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[5]")).click();
//        driver.findElement(By.xpath("(//*[text()='Calendar Events'])[1]")).click();
        VyTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();

        //since vytrack displays overlay screen during loading of the page
        //we have wait, until that overlay screen disappear
        VyTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();

        List<String> expectedOptions = Arrays.asList("Daily", "Weekly","Monthly", "Yearly");
        List<String> actualOptions = calendarPage.getRepeatOptions();

        //correct way to check if 2 collections are equals
        Assert.assertEquals(actualOptions, expectedOptions);

    }

    @Test
    public void DailyRepeatOptionRepeatEveryTest(){

    }


    //AfterMethod id coming from TestBase
}