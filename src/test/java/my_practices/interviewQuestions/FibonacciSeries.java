package my_practices.interviewQuestions;

public class FibonacciSeries {
    public static void main(String[] args) {
        int k=0, a=1, b=1;
        System.out.print("1 1 ");

        while (k <= 50){
            k = a + b;
            System.out.print(k + " ");
            a = b;
            b = k;
        }

    }

}
