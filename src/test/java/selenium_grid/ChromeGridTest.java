package selenium_grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeGridTest {

    //Download the Selenium Standalone Server jar file
    //Chrome driver
    //Get the command from https://github.com/SeleniumHQ/selenium/wiki/Grid2

    //First command: java -jar selenium-server-standalone-3.141.59.jar -role hub
    //Second command: java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.MAC);

        ChromeOptions options = new ChromeOptions();
        options.merge(cap);

        String hubUrl = "http://192.168.1.129:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);

        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
    }

}

/*
Create Grid folder in Desktop
Copy paste: ChromeDriver latest version from URL: https://www.google.com/chrome/
        selenium-server-standalone-3.141.59 from URL: https://www.seleniumhq.org/download/
cd Desktop
cd Grid
ls
java -jar selenium-server-standalone-3.141.59.jar -role hub
7. java -Dwebdriver.chrome.driver="chrome" -jar selenium-server-standalone-3.141.59.jar -role node  -hub http://localhost:4444/grid/register
// How to terminate on MAC control+C
7.1  // if doesn’t work redo the step 7 as below
java -jar selenium-server-standalone-3.141.59.jar -role node -hubttp://localhost:4444/grid/register

Selenium Grid - is a tool that allows to perform remote execution on different platforms, operation systems, browser, versions..
Grid consists of 2 main components:
Hub and Node
We should have one hub and 1+ node.
Hub will be point of contact for RemoteWebDriver. But, it doesn't run tests itself. Tests will be running on nodes. Based on DesiredCapabilities, hub will select node for running your tests.
1. Download Selenium Standalone Server:
https://seleniumhq.org/download/
2. Download webdrivers. that you want to use
3. Execute in terminal:
java -jar selenium-server-standalone-3.141.59.jar -role hub
To start hub.

java -jar selenium-server-standalone-3.141.59.jar -role hub


java -Dwebdriver.chrome.driver="chrome" -jar selenium-server-standalone-3.141.59.jar -role node  -hub http://localhost:4444/grid/register

java -jar selenium-server-standalone-3.141.59.jar -role node -hubttp://localhost:4444/grid/register

 */
