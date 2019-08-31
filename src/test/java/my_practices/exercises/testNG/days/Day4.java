package my_practices.exercises.testNG.days;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Day4 {

    public WebDriver driver;


    @Test
    public void Login() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/yasinbekar/IdeaProjects/SeleniumTutorials/src/test/java/my_practices/exercises/testNG/data.properties");
        prop.load(fis);
        driver = Driver.getDriver();
        driver.get(prop.getProperty("url"));

        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
        System.out.println(prop.getProperty("url"));

        if (prop.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
        }else if(prop.getProperty("browser").equals("chrome")){
            driver = new ChromeDriver();
        }else{
            driver = new InternetExplorerDriver();
        }


    }



}
