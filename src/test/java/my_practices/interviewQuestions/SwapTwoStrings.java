package my_practices.interviewQuestions;

public class SwapTwoStrings {
    public static void main(String[] args) {

        String a = "Hello";
        String b = "World";
        System.out.println("Before swapping: " + a + " " + b);

        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());

        System.out.println("After swapping: " + a + " " + b);
    }
}
