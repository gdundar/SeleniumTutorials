package my_practices.exercises.seleniumExercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucelabsTest {
    public static final String USERNAME = "ybekar02";
    public static final String ACCESS_KEY = "f8ca8a20-aa5a-47b5-aaa2-7f610308a492";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "macOS 10.13");
        caps.setCapability("version", "76.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://google.com");
        System.out.println(driver.getTitle());



    }
}