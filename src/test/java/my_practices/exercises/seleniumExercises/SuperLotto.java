package my_practices.exercises.seleniumExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SuperLotto {


    WebDriver driver;

    @BeforeClass
    public void setuo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.calottery.com/play/draw-games/superlotto-plus");
    }

    @Test
    public void superLottoTable(){

        WebElement table = driver.findElement(By.cssSelector("table[class='draw_games tag_even']"));
        int count = table.findElements(By.xpath("//table/tbody/tr//td[2]")).size();

        int sum=0;
        for(int i=0; i < count; i++){
            System.out.println(table.findElements(By.xpath("//table/tbody/tr//td[2]")).get(i).getText());
            String value = table.findElements(By.xpath("//table/tbody/tr//td[2]")).get(i).getText().replace("," , "");
            Integer num = Integer.parseInt(value);
            sum += num;
        }
        System.out.println(sum);
        System.out.println(driver.findElement(By.cssSelector("span[id='objBody_content_0_pagecontent_0_lblTotal']")).getText());

    }


    @AfterClass
    public void tearDown(){

        driver.close();

}


}
