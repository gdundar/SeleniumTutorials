package my_practices.interviewQuestions.OOPConcepts;

import java.util.Scanner;

public class EvenOddNums {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if(num % 2== 0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }


        int[] number = {1,2,3,4,5,6,7,8,9};
        for(int printnum : number){
            if(printnum % 2 == 0){
                System.out.println("even");
            }else{
                System.out.println("odd");
            }
        }

        for (int i = 0; i <number.length ; i++) {
            if(number[i] % 2 == 0){
                System.out.println("even");
            }else{
                System.out.println("odd");
            }
        }
    }

}
