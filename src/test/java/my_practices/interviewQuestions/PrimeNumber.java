package my_practices.interviewQuestions;

public class PrimeNumber {

    //method caculates if the number is prime or not
    public static boolean isPrimeNumber(int num){

        if(num <= 1){
            return false;
        }
        for(int i =2; i< num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    //method calculates how many prime numbers are there up to hte number
    public static void getPrimeNumbers(int num){
        for (int i =2; i <=num; i++){
            if(isPrimeNumber(i))
                System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        System.out.println(isPrimeNumber(4));
        System.out.println(isPrimeNumber(3));
        System.out.println(isPrimeNumber(1));
        System.out.println(isPrimeNumber(13));
        System.out.println(isPrimeNumber(20));
        System.out.println(isPrimeNumber(-7));

        getPrimeNumbers(19);
        getPrimeNumbers(9);
        getPrimeNumbers(10);
    }
}
