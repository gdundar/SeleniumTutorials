package my_practices.exercises.seleniumExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.expedia.com/");
    }

    @Test
    public void expediaSelectCity() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@aria-owns='typeaheadDataPlain'])[7]"))));

        //I can select either id or css selector --- input[id='package-origin-hp-package']

        driver.findElement(By.xpath("(//input[@aria-owns='typeaheadDataPlain'])[7]")).sendKeys("Toronto");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@aria-owns='typeaheadDataPlain'])[7]")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@aria-owns='typeaheadDataPlain'])[7]")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@aria-owns='typeaheadDataPlain'])[7]")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@aria-owns='typeaheadDataPlain'])[7]")).sendKeys(Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor )driver;
        String script = "return document.getElementById(\"package-origin-hp-package\").value;";
        String result = (String) js.executeScript(script);
        System.out.println(result);

        //We need JS since it is hidden text
        // System.out.println(driver.findElement(By.xpath("(//input[@aria-owns='typeaheadDataPlain'])[7]")).getText());

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='package-destination-hp-package']")).sendKeys("Dallas");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='package-destination-hp-package']")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='package-destination-hp-package']")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='package-destination-hp-package']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        //JavascriptExecutor js2 = (JavascriptExecutor )driver;
        String script2 =  "return document.getElementById(\"package-destination-hp-package\").value;";
        //we do not need to call js2 - javascript can be called ONCE which is above
        String result2 = (String) js.executeScript(script2);
        System.out.println(result2);

        driver.findElement(By.cssSelector("input[id='package-departing-hp-package']")).click();

        while (!driver.findElement(By.cssSelector("div[class='datepicker-cal-month'] caption[class='datepicker-cal-month-header']")).getText().contains("Jan")) {
            driver.findElement(By.xpath("//button[contains(@class,'datepicker-next')]")).click();
            //String month = driver.findElement(By.cssSelector("caption[class='datepicker-cal-month-header']")).getText();
            if (driver.findElement(By.cssSelector("div[class='datepicker-cal-month'] caption[class='datepicker-cal-month-header']")).getText().contains("Jan")) {
                System.out.println(driver.findElement(By.cssSelector("div[class='datepicker-cal-month'] caption[class='datepicker-cal-month-header']")).getText());
                //System.out.println(month);
                break;
            }
        }
        System.out.println("done");
        Thread.sleep(3000);

        String day;
        ////div/table/tbody/tr/td[2]/button --> Number of days
        for(int i=0; i < (driver.findElements(By.xpath("//div/table/tbody/tr/td[2]/button")).size()); i++){
            day = (driver.findElements(By.xpath("(//button[@data-day='23'])[1]"))).get(i).getText();
            if(((driver.findElements(By.xpath("(//button[@data-day='23'])[1]"))).get(i).getText()).contains("23")){
                driver.findElements(By.xpath("(//button[@data-day='23'])[1]")).get(i).click();
                System.out.println(day);
            }
        }
    }


        @AfterClass
    public void tearDown(){

        driver.close();

    }
}
