package my_practices.interviewQuestions;

public class ArmstrongNumber {
    //is a number that is the sum of its own digits each raised to the power of the number of digits.
    //abcd... = an + bn + cn + dn + ...
    //153 = (1*1*1)+(5*5*5)+(3*3*3)

    public static void isArmStrongNumber(int number){
        System.out.println("The number is: " + number);
        int cube = 0;
        int remainder;
        int i = number;
        while (number > 0) {
            remainder = number % 10;
            cube = cube + (remainder * remainder * remainder);
            number = number / 10;
        }
        System.out.println("The reversed number is: " + cube);

        if(i == cube){
            System.out.println(cube + " IS an armstrong");
        }else {
            System.out.println(cube + " is NOT an armstrong!");
        }
    }

    public static void main(String[] args) {
        isArmStrongNumber(153);
    }
}
