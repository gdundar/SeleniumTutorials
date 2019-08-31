package my_practices.exercises.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators_BYXPATH {
    public static void main(String[] args) throws Exception{
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");
        WebElement dropDown = driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[3]/a"));
        System.out.println(dropDown.getText());

        Thread.sleep(3000);
        dropDown.click();
        Thread.sleep(3000);

        driver.navigate().to("http://practice.cybertekschool.com/");
        WebElement span = driver.findElement(By.xpath("//span[@class=\'h1y\']"));
        System.out.println(span.getText());

        Thread.sleep(3000);

        WebElement contextMenu = driver.findElement(By.xpath("//a[.='Context Menu']"));
        System.out.println(contextMenu.getText());
        contextMenu.click();
        Thread.sleep(2000);

        WebElement dragDrop = driver.findElement(By.xpath("//a[@href='/drag_and_drop']"));
        System.out.println(contextMenu.getText());
        contextMenu.click();
        Thread.sleep(2000);

        driver.close();

    }
}
