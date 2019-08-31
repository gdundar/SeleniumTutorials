package my_practices.interviewQuestions;

import java.util.Arrays;

public class LargestSmallestNumbers {

    public static void main(String[] args) {

        int numbers[] = {10, 24, 50, -88, 9776};
        int largest = numbers[0];
        int smallest = numbers[0];

        for(int i =0; i < numbers.length; i++){
            if(numbers[i] > largest){
                largest = numbers[i];
            }else if(numbers[i] < smallest){
                smallest = numbers[i];
            }
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(largest + " " + smallest);



        for(int i=0; i< numbers.length; i++){
            if(numbers[i] > largest){
                largest = numbers[i];
            }
        }
        System.out.println(largest);

        for(int i=0; i< numbers.length; i++){
            if(numbers[i] < smallest){
                smallest = numbers[i];
            }
        }
        System.out.println(smallest);

    }



}
