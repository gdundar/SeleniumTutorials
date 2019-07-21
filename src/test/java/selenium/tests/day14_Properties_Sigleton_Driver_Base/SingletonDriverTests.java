package selenium.tests.day14_Properties_Sigleton_Driver_Base;

import org.testng.annotations.Test;
import selenium.utilities.Driver;
import selenium.utilities.SeleniumUtils;

public class SingletonDriverTests {

    @Test
    public void test1(){
        Driver.getDriver().get("http://google.com");
        SeleniumUtils.waitPlease(2);
        Driver.closeDriver(); // to completely shutdown driver
    }
}
