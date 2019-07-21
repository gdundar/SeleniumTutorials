package selenium.tests.day14_Properties_Sigleton_Driver_Base;

import org.openqa.selenium.By;
import selenium.utilities.Driver;

public class LoginPage {
    String userNameLocator = "prependedInput";
    String passwordLocator = "prependedInput2";
    String loginButtonLocator = "_submit";

    public void login(String userName, String password){
        Driver.getDriver().findElement(By.id(userNameLocator)).sendKeys(userName);
        Driver.getDriver().findElement(By.id(passwordLocator)).sendKeys(password);
        Driver.getDriver().findElement(By.id(loginButtonLocator)).click();
    }
}
