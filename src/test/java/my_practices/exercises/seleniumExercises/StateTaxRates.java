package my_practices.exercises.seleniumExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StateTaxRates {

    WebDriver driver;


    @BeforeClass
    public void setuo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.money-zine.com/financial-planning/tax-shelter/state-income-tax-rates/");

    }

    @Test
    public void calculateIncomeTax(){

        WebElement table = driver.findElement(By.cssSelector("table[class='table-bordered']"));
        int count = table.findElements(By.xpath("//div/div/table/tbody/tr/td[3]")).size();

        int sum=0;
        for(int i=1; i< count-1; i++) {
            System.out.println(table.findElements(By.xpath("//div/div/table/tbody/tr/td[3]")).get(i).getText());
            String val = (table.findElements(By.xpath("//div/div/table/tbody/tr/td[3]")).get(i).getText()).replace(" ", "");
            if ( ! val.equals("")) {
                Integer num = Integer.parseInt(val);
                sum += num;
            }
        }
        System.out.println(sum);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
