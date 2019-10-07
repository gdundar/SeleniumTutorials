package my_practices.interviewQuestions;

public class FindMissingNumber {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,7}; //used to be {1,2,3,4,5} --> 3 is missing
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum = sum + a[i];
        }
        System.out.println(sum);
        int sum2 = 0;
        for(int j = 1; j <= 7; j++){
            sum2 = sum2 + j;
        }
        System.out.println(sum2);
        System.out.println(sum2 - sum);
    }



}
