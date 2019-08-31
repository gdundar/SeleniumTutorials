package my_practices.interviewQuestions;

public class ReversingString {

    public static void main(String[] args) {
       //method-1
        reversingString("Selenium");

        //method-2
        String reverse = "Cucumber";
        String str="";
        for(int i= reverse.length()-1; i>=0; i--){
            str += reverse.charAt(i);
        }
        System.out.println(str);

        //method-3
        String sb = "Java";
        StringBuffer stringBuffer = new StringBuffer(sb);
        System.out.println(stringBuffer.reverse());
    }


    public static String reversingString(String reverse){
        String str="";
        for(int i= reverse.length()-1; i>=0; i--){
            //why reverse.length()-1 ? -->
            // the length of the string is 8 but we start from index 7, so 8-1=7
            str += reverse.charAt(i);
        }
        System.out.println(str);
        return str;
    }
}
