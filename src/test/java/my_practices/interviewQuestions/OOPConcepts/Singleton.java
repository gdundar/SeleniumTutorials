package my_practices.interviewQuestions.OOPConcepts;

import cucumber.api.java.ro.Si;

public class Singleton {
    //Singleton can have only once object creatin at a time.
    //make a constructor as private
    //write a static method that returns type object of Singleton class

    private static Singleton singleObject = null;
    private  String str;

    private Singleton() {
        str = "Hello Singleton!";
    }

    public static Singleton getInstance() {
        if (singleObject == null)
            singleObject = new Singleton();
        return singleObject;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.str);
    }
}
