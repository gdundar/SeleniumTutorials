package selenium.tests.day16_webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class WebTableTests extends TestBase {

    @Test
    public void printableTest(){
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());

        WebElement head = driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
        System.out.println(head.getText());
    }

    @Test
    public void printHeaderRow(){
        WebElement table = driver.findElement(By.id("table1"));
        int num = driver.findElements(By.tagName("thead")).size();

        for(int i = 0; i < num; i++){
            System.out.println(driver.findElements(By.tagName("thead")).get(i).getText());
        }
    }

    @Test
    public void countRows(){
        String numOfRows = "table[id='table1'] > tbody tr";
        List<WebElement> rows = driver.findElements(By.cssSelector(numOfRows));
        System.out.println(rows.size());

        System.out.println(driver.findElements(By.cssSelector("table[id='table1'] > tbody tr")).size());
    }

    @Test
    public void countRowTest2(){
        String numOfRows2 = "#table2 tr"; //including the header of the table
        List<WebElement> rows2 = driver.findElements(By.cssSelector(numOfRows2));
        System.out.println(rows2.size());
        Assert.assertEquals(rows2.size(), 5);
    }

    @Test
    public void printableHeaders(){
        String locator = "#table1 th";
        List<WebElement> headers = driver.findElements(By.cssSelector(locator));
        for (WebElement header: headers){
            System.out.println(header.getText());
        }
    }

    @Test
    public void printSpecifRow(){
        int row = 3;
        String locator = "//table[1]//tbody//tr["+row+"]";
        WebElement rowElement = driver.findElement(By.xpath(locator));
        System.out.println(rowElement.getText());
    }

    @Test
    public void verifyThatNameDisplays(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String actualName = driver.findElement(By.xpath(firstNameLocator)).getText();
        String actualLastName = driver.findElement(By.xpath(lastNameLocator)).getText();

        Assert.assertEquals(actualName, firstName);
        Assert.assertEquals(actualLastName, lastName);
    }


    @Test
    public void printColumnTest(){

        System.out.println(getColumn("Email"));
    }

    public List<String> getColumn(String columnName){

        List<String> values = new ArrayList<>();
        //all headings
        List<WebElement> headings = driver.findElements(By.xpath("//table[1]//th"));
        int columnNumber = 0;
        //we are looping though collection of headings
        for(int i =0; i< headings.size();i++){
            //we are looking for position of heading
            if(headings.get(i).getText().equals(columnName)){
                columnNumber = i+1;
                break;
            }
        }
        //based on position that we found in previous loop, we allocating column
        List<WebElement> columnList = driver.findElements(By.xpath("//table[1]//tr//td["+columnNumber+"]"));

        for(WebElement columnValue: columnList){
            values.add(columnValue.getText());
        }

        return values;
    }


}
