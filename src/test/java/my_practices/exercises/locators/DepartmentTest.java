package my_practices.exercises.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DepartmentTest {

    WebDriver driver;
    Select allDepartments;

    @BeforeClass
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test(priority = 0)
    public void testDefaultValue(){
        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));

        allDepartments = new Select(selectElement);
        String selectedOption = allDepartments.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "All Departments");

    }

    @Test(priority = 1)
    public void sortAlphabebtical(){
        for (int i = 0; i < allDepartments.getOptions().size()-1; i++){
            String current = allDepartments.getOptions().get(i).getText();
            String next = allDepartments.getOptions().get(i+1).getText();

            System.out.println("Comparing... " +  current + " with " + next);

            Assert.assertTrue(current.compareTo(next) <= 0);
        }
    }

    @Test(priority = 2)
    public void mainDepartmentsTest() throws Exception{

            driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("a[href='/gp/site-directory?ref_=nav_em_T1_0_2_2_35__fullstore']")).click();
            Thread.sleep(3000);

            List<WebElement> mainDep = driver.findElements(By.cssSelector("h2.fsdDeptTitle"));
            for(WebElement option : mainDep){
                System.out.println(option.getText());
            }
    }

    @AfterClass
    public void tearDown(){
            driver.close();
    }
}
