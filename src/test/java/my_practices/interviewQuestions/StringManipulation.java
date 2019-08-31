package my_practices.interviewQuestions;

public class StringManipulation {

    public static void main(String[] args) {

        String str = "The rains have started here";
        String str2 = "The rains have started here";

        System.out.println(str.length());
        System.out.println(str.charAt(5));
        System.out.println(str.indexOf('s'));
        System.out.println(str.indexOf('s', str.indexOf('s') + 1));
        System.out.println(str.indexOf("have"));
        System.out.println(str.equalsIgnoreCase(str2));
        System.out.println(str.substring(3, 8));

        String date = "01-06-1989";
        System.out.println(date.replace("-", "/"));

        String toBeSplitted[] = str.split(" ");
        for (int i = 0; i < toBeSplitted.length; i++) {
            System.out.println(toBeSplitted[i]);
        }

        String h = "Welcome, Hello there!";
        String[] sp = h.split(" ",2);
        for (String a: sp) {
            System.out.println(a);
        }

        System.out.println(h.concat(date));

    }
}
