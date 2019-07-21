package selenium.tests.day14_Properties_Sigleton_Driver_Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.utilities.ConfigurationReader;
import selenium.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    Actions action;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

}
