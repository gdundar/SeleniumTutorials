package my_practices.exercises.testNG.days;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

    @Parameters({"URL"})
    @Test
    public void day3(@Optional String urlname){
        System.out.println("Hello Selenium");
        System.out.println(urlname);
    }

    @Test(groups={"weakTest"})
    public void darkday(){
        System.out.println("Move away dark days!");
    }

    @Test(groups={"smoke"})
    public void snowyday(){
        System.out.println("Hello snowy days!");
    }

    @Test(groups={"smoke"})
    public void rainyday(){
        System.out.println("Hello rainy  days!");
    }

    @Test(groups={"smoke"})
    public void sunyday(){
        System.out.println("Hello sunny days!");
    }
}
