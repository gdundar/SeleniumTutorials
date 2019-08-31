package my_practices.interviewQuestions;

public class SwapNumbersWithTemp {

    public static void main(String[] args) {

        //COMMENT out the methods one by one to see the results!!!

        //temp method
        int x = 5;
        int y = 10;
        System.out.println("x: " + x + " and " + "y: " + y);

        int temp = x;
        x = y;
        y = temp;
        System.out.println("x: " + x + " and " + "y: " + y);

        //X OR - Binary method
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println("x: " + x + " and " + "y: " + y);

        //using multiply operation
        x = x * y; //50
        y = x / y; //10
        x = x / y; //5

        System.out.println("x: " + x + " and " + "y: " + y);
    }
}