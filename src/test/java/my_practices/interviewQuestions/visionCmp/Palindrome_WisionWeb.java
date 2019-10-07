package my_practices.interviewQuestions.visionCmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Palindrome_VisionWeb {

    public static void main(String[] args) {
        visionWeb();
        System.out.println("-----The next method is been called-----");
        reversingNumber(171);
        System.out.println("-----The next method is been called-----");
        removeZeros(new int[]{6, 0, 45, 0, 0, 0, 56, 0, 23, 0});
    }

    public static void visionWeb(){
        String visionWeb = "Vision Web SDET Role";
        String[] empty= visionWeb.split(" ");

        for (int i=empty.length-1; i >=0; i--){
            System.out.print(empty[i] + " ");
        }
        System.out.println();
    }

    public static void reversingNumber(int number) {
        int initial = number;
        int result;
        int reversed = 0;
        while (number > 0) {
            result = number % 10;
            reversed = reversed * 10 + result;
            number = number / 10;
        }
        System.out.println("The initial number is: " + initial + " " + "The reversed number is: " +reversed);
            if (initial == reversed) {
                System.out.println("The number is a PALINDROME: " + reversed);
            } else
                System.out.println("The number is NOT a palidrome! " + reversed);
        }


    public static void removeZeros(int [] zeros){
        List<Integer> result = new ArrayList<>();
        for(int i =0; i < zeros.length-1; i++){
            if(zeros[i] != 0){
                result.add(zeros[i]);
            }
        }
        System.out.println(result);
    }
}



