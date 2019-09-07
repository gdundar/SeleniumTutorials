package selenium_grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeGridTest {

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
