package my_practices.interviewQuestions;

public class RemovingCharacters {
    public static void main(String[] args) {

        String s = "Hello Spartan 123";
        s = s.replaceAll("[^a-zA-z]", "");
        System.out.println(s);

        String str = "Hello Spartan 123";
        str = str.replace("[^0-9]", "");
        System.out.println(str);
    }
}