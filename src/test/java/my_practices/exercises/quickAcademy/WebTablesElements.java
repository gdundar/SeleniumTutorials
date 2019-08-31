package my_practices.exercises.quickAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesElements {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$password']")).sendKeys("test" + Keys.ENTER);

    }

    @Test
    public void test() {
        WebElement table = (driver.findElement(By.id("ctl00_MainContent_orderGrid")));
        System.out.println(table.getText());

    }

    @Test
    public void printAllHeaders(){
        System.out.println(driver.findElement(By.xpath("//div/table/tbody/tr[1]")).getText());
        System.out.println("------ Second Way --------");
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for(WebElement header : headers){
            System.out.println(header.getText());
        }
    }


    @Test
    public void zipcodes(){
        //will print ONLY ConfigurationReader of the values.
        WebElement zip = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        int count = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[9]")).size();
        for(int i=0; i < count; i++) {
            System.out.println(zip.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[9]")).get(i).getText());

        }

        System.out.println("--- Second Way ---");

        List<WebElement> zipcodes = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[9]"));

        for(WebElement each : zipcodes){
            System.out.println(each.getText());
        }
    }

    @Test
    public void printTableSize(){
        WebElement alllRows = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("Number of rows: " + alllRows);
        WebElement allHeaders = driver. findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        System.out.println("Number of columns : " + allHeaders);
    }

    @Test
    public void printRow2(){
        WebElement row2 = driver. findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]"));
        System.out.println(row2.getText());
    }

    @Test
    public void printAllCellsInOneRow(){
        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));
        for(WebElement header : cells){
            System.out.println(header.getText());
        }
    }

    @Test
    public void printByCoordinates(){
        WebElement cell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[11]"));
        System.out.println(cell.getText());

        System.out.println(getCellInfo(4, 8).getText());
    }

    public WebElement getCellInfo(int row, int col){
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+ "]/td["+col+"]";
        return driver.findElement(By.xpath(xpath));
    }

    @Test
    public void selectCheckBox(){
        WebElement checkBox = driver.findElement(By.xpath("//td[.='Steve Johns']/../td[1]/input")); //anotherway xpath : //table[@id='ctl00_MainContent_orderGrid']//tr[2]/td/input
        System.out.println(checkBox.isSelected());
        checkBox.click();
        System.out.println(checkBox.isSelected());
    }

    @Test
    public void pickNameAndCity(){
        int nameIndex = getColumnIndex("Name");
        System.out.println(nameIndex);
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nameIndex+"]"));
        boolean found = false;
        for(int i=0; i< allNames.size(); i++){
            if(allNames.get(i).getText().equals("Mark Smith")){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    public int getColumnIndex(String column){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for(int i=0; i< headers.size(); i++){
            if(headers.get(i).getText().equals(column)){
                return i+1;
            }
        }
        return headers.indexOf(column);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}