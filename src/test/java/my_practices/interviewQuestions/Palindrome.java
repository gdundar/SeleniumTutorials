package my_practices.interviewQuestions;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Palindrome {

    public static void isPalindrome(int number) {
        System.out.println("The number is: " + number);
        int result = 0;
        int remainder;
        int start = number;
        while (number > 0) {
            remainder = number % 10;
            result = result * 10 + remainder;
            number = number / 10;
        }
        System.out.println("The reversed number is: " + result);

        if(start == result){
            System.out.println(result + " IS a palindrome");
        }else {
            System.out.println(result + " is NOT a palindrome!");
        }

    }

    public static  void isPalindromeString(String palindrome){
        //assumed it has no space in the sentence
        String result ="";
        for(int i = palindrome.length()-1; i>=0; i--){
            result += palindrome.charAt(i);
        }
        System.out.println("The reversed string is: " + result);

        if(palindrome.equalsIgnoreCase(result)){
            System.out.println(result + " IS a palindrome");
        }else {
            System.out.println(result + " is NOT a palindrome!");
        }
    }

    public static void main(String[] args) {
        isPalindrome(343);

        isPalindromeString("Hello");
        isPalindromeString("ana");

        //a number is divided by a bigger number result is 0
        //a number`s remainder by a bigger number result is the same number as itself, NOT a zero!!!
//        int i, c;
//        System.out.println(i = 3/10);
//        System.out.println(c = 3%10);

    }
}

