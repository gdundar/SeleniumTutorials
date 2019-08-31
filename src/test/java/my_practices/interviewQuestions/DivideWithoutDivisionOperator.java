package my_practices.interviewQuestions;

public class DivideWithoutDivisionOperator {

    // write a program which divides 2 numbers without using division operator.
    public static void main(String[] args) {
        double result = divideWithoutDivssionOperator(100000, 10);
        System.out.println(result);
    }
    public static double divideWithoutDivssionOperator(double num1, double num2){
        if (num1 < num2){
            System.out.println("This program only handles positive numbers !!! ");
        }else if(num2 == 0){
            throw new ArithmeticException("Attention!!! the number can't be divided by 0");
        }
        double num3 = 0;
        double result = 0;
        num3 = num1 + num2;
        while (num3 > num2){
            num3 = num3 - num2;
            result++;
        }
        return result;
    }

}
