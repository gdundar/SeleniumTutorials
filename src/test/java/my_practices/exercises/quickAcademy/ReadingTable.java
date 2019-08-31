package my_practices.exercises.quickAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadingTable {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");
    }

    @Test
    public void readingTable(){
        WebElement table = driver.findElement(By.id("product"));
        int count = table.findElements(By.xpath("//table/tbody/tr/following-sibling::tr/td[1]")).size();
        System.out.println(count);
        int sum=0;
        for(int i=0; i< count; i++){
            System.out.println(table.findElements(By.xpath("//table/tbody/tr/following-sibling::tr/td[1]")).get(i).getText());
            System.out.println(table.findElements(By.xpath("//table/tbody/tr/following-sibling::tr/td[2]")).get(i).getText());
            System.out.println(table.findElements(By.xpath("//table/tbody/tr/following-sibling::tr/td[3]")).get(i).getText());

            String num = table.findElements(By.xpath("//table/tbody/tr/following-sibling::tr/td[3]")).get(i).getText();
            Integer n = Integer.parseInt(num);
            sum += n;
        }
        System.out.println(sum);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
