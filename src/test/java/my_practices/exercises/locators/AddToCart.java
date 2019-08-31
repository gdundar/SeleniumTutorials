package my_practices.exercises.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        Thread.sleep(3000);

        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);

        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Walter Savitch java book" + Keys.ENTER);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Walter Savitch java book");
        driver.findElement(By.className("nav-input")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\'search\']/div[1]/div[2]/div/span[3]/div[1]/div[3]/div/div/div/div[2]/div[1]/div/div/span/a/div/img")).click();
        driver.findElement(By.id("add-to-cart-button")).click();



        String textBook = driver.findElement(By.className("Java: An Introduction to Problem Solving and Programming (8th Edition)")).getText();
        System.out.println(textBook);

        if(textBook.equals("Java: An Introduction to Problem Solving and Programming (8th Edition) ") ){
            System.out.println("Success! The book is your cart");
        }else{
            System.out.println("An error occured, try again!");
        }



        //driver.close();

    }

}
