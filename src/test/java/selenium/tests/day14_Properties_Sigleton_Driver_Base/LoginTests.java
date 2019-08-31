package selenium.tests.day14_Properties_Sigleton_Driver_Base;

import org.testng.annotations.Test;
import selenium.pages.vytrack.LoginPage;
import selenium.utilities.ConfigurationReader;
import selenium.utilities.TestBase;

public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTests1(){
        //DEMO for reading credentials from properties file
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
    }
}
