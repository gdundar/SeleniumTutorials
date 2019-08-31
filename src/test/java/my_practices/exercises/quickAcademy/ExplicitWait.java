package my_practices.exercises.quickAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utilities.Driver;

public class ExplicitWait {

    @Test
    public void test() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
        Driver.getDriver().findElement(By.cssSelector("button[onclick='swapInput()']")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='text']")));

        Driver.getDriver().findElement(By.cssSelector("input[type='text']")).sendKeys("Hello World");

        //Will not work to extract the text
        //wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.cssSelector("input[type='text']"))));

        //still can not get the text - NO tag name or ID
//        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
//        String text = (String) js.executeScript("return document.getElementsByTagName(\"there is NO tagname\").value;");
//        System.out.println(text);

        //gives null
        System.out.println( Driver.getDriver().findElement(By.cssSelector("input[type='text']")).getText());
        //GIVES the value - The right ConfigurationReader
        System.out.println( Driver.getDriver().findElement(By.cssSelector("input[type='text']")).getAttribute("value"));


    }

    @Test
    public void test2(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        Driver.getDriver().findElement(By.tagName("button")).click();
        WebElement text = Driver.getDriver().findElement(By.cssSelector("#finish h4"));

        WebDriverWait wait =  new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(text));

        System.out.println(text.getText());
        Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void test3(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        Driver.getDriver().findElement(By.tagName("button")).click();
        WebElement text = Driver.getDriver().findElement(By.cssSelector("#finish h4"));

        WebDriverWait wait =  new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[.='Loading... ']")));

        System.out.println(text.getText());
        Assert.assertTrue(text.isDisplayed());
    }


}
