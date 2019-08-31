package my_practices.interviewQuestions;

public class GreatCommonDivisor {
    public static void main(String[] args) {

        int num1 =120;
        int num2 =80;
        int gcd =0;
        for(int i =1; i<=num1; i++){
            if(num1 % i ==0 && num2 % i ==0){
                gcd =i;
            }
        }
        System.out.println(gcd);
    }

}
