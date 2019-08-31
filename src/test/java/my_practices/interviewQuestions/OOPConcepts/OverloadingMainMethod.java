package my_practices.interviewQuestions.OOPConcepts;

//Can we overload main method?
//*JVM looks for main(String[] args) which is public static void -> MAIN method.
//Main method can be overloaded! public static void main(int a){ }

public class OverloadingMainMethod {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(main());
        System.out.println(main(3));
    }

    public static String main() {
        return "Bye !";
    }

    public static int main(int num) {
        return num;
    }
}
