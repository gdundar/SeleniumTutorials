package my_practices.interviewQuestions;

import java.util.Arrays;

public class UniqueChars {

    public static void main(String[] args) {
        String str = "abcdabcd";
        String unique = "";
        for (int i = 0; i < str.length(); i++) {
            if (!unique.contains(str.substring(i))) {
                unique += str.charAt(i);
            }
        }
        System.out.println(unique);
    }
}
