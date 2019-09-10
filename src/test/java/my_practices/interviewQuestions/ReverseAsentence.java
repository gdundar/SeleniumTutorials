package my_practices.interviewQuestions;

public class ReverseAsentence {
    public static void main(String[] args) {
        String str = "Hello Java World";
        String[] str1 = str.split(" ");
        for (int i = str1.length-1; i >= 0; i--) {
            System.out.println(str1[i]);
        }
    }
}
