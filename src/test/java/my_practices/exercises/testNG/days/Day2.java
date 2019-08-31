package my_practices.exercises.testNG.days;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day2 {

        @Test(dataProvider = "getData")
        public void day2(String username, String password){
            System.out.println("Hello Java");
            System.out.println(username);
            System.out.println(password);
        }

        @DataProvider
        public Object[][] getData(){ // can be static to be used in other methods
            Object[][] data = new Object[3][2];
            data[0][0] = "first username";
            data[0][1] = "first password";

            data[1][0] = "second username";
            data[1][1] = "second password";

            data[2][0] = "third username";
            data[2][1] = "third password";

            return data;
        }

}
