package Selenium.Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EatsySearch {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(3000);

        String text = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(text);

        driver.findElement(By.xpath("//a[@href='https://www.ebay.com/sch/i.html?_from=R40&_nkw=wooden+spoon&_oac=1']")).click();
        Thread.sleep(3000);
        String text2 = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        Thread.sleep(3000);
        System.out.println(text2);

        String st1 = "";
        for(int i=0; i< text.length(); i++){
            if(text.charAt(i) =='0' || text.charAt(i) =='2'||text.charAt(i) =='1' ||text.charAt(i) =='3' || text.charAt(i) =='4' ||
                    text.charAt(i) =='5' || text.charAt(i) =='6' ||text.charAt(i) =='7' || text.charAt(i) =='8' ||
                    text.charAt(i) =='9')
                st1 += text.charAt(i);
        }
        System.out.println(st1);

        String st2 = "";
        for(int i=0; i< text2.length(); i++){
            if(text2.charAt(i) =='0' || text2.charAt(i) =='2'||text2.charAt(i) =='1' ||text2.charAt(i) =='3' || text2.charAt(i) =='4' ||
                    text2.charAt(i) =='5' || text2.charAt(i) =='6' ||text2.charAt(i) =='7' || text2.charAt(i) =='8' ||
                    text2.charAt(i) =='9')
                st2 += text2.charAt(i);
        }
        System.out.println(st2);

//        String i1 = text.replaceAll("[^ 0123456789]", "").trim();
//        String i2 = text2.replaceAll("[^ 0123456789]", "").trim();
//
        Integer num1 = Integer.parseInt(st1); // there is NO "" for st1 and st2!!! NOT "st1"
        Integer num2 = Integer.parseInt(st2);

        if(num1 < num2){
            System.out.println("You have more items");
        }else{
            System.out.println("You got less items");
        }
        driver.navigate().back();
        Thread.sleep(3000);

        String woodenSpoon =  driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
        Thread.sleep(3000);

        if(woodenSpoon.equals("wooden spoon")){
            System.out.println("Includes the item");
        }else{
            System.out.println("Does not include");
            System.out.println(woodenSpoon);
        }

        driver.navigate().back();
        String blank = driver.findElement(By.xpath("//input[@type='text']")).getText();
        Thread.sleep(3000);

        if(blank.equals("")){
            System.out.println("Search box is blank");
        }else{
            System.out.println("Search box is NOT blank");
            System.out.println(blank);
        }

        Thread.sleep(3000);
        driver.close();
    }
}
