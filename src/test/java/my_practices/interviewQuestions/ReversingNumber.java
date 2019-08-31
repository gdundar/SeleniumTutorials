package my_practices.interviewQuestions;

public class ReversingNumber {

    public static void main(String[] args) {

        //BEST way
        int num = 12345;
        int revNum = 0;

        while(num != 0){
            revNum = revNum * 10 + num % 10;
            num = num / 10;
        }
        System.out.println("The reversed number is: " + revNum);


        //Substring method
        int number = 6789;
        String numStr = String.valueOf(number);
        StringBuffer sb = new StringBuffer(numStr);
        sb.reverse();
        System.out.println("The reversed number is: " +sb);


        reverse(34663234);
    }

    //via a method
    public static void reverse(int n) {
        int result = 0;
        int rem;
        while (n > 0) {
            rem = n % 10;
            result = result * 10 + rem;
            n = n / 10;
        }
        System.out.println("The reversed number is: " + result);
    }
}
