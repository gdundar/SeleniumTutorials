package selenium.tests.day14_Properties_Sigleton_Driver_Base;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utilities.ConfigurationReader;

public class ConfigurationReaderTests {

    @Test
    public void test1(){
        String expected = "chrome";
        String actual = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        String expectedUserName = "storemanager";
        String actualUserName = ConfigurationReader.getProperty("username");
        Assert.assertEquals(actualUserName, expectedUserName);
    }

}
