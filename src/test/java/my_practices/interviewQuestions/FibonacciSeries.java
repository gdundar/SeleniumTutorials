package my_practices.interviewQuestions;

public class FibonacciSeries {
    public static void main(String[] args) {
        int k = 0, a = 1, b = 1;
        System.out.print("1 1 ");

        while (k <= 50) {
            k = a + b;
            System.out.print(k + " ");
            a = b;
            b = k;
        }

        /*
        for(int i = 2; i <=10; i++) { int c = a+b;
        a = b;
        b = c;
        System.out.print(c + " + "); }
         */

    }

}
