package my_practices.interviewQuestions;

public class SquareSumOfArray {


    public static void main(String[] args) {
        int[] num ={1,5,8,9};
        System.out.println(squareOfSum(num));
    }

    public static int squareOfSum(int [] numbers){
        int result =0;

        for(int i=0; i< numbers.length; i++){
            result += numbers[i] * numbers[i];
        }
        return result;
    }

}
