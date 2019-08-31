package my_practices.interviewQuestions.OOPConcepts;

public class ChildOverride extends ParentOverride{

    //METHOD OVERRIDING!!!!
    @Override
    public void setUp() {
        System.out.println("Overridden the parent method");
    }

    //Overloaded static method!!!
    public static void setUp(int a) {
        System.out.println("Overridden the parent method");
    }

    //OVERLOADED static method!!! BUT STATIC method can NOT BE Overridden!!!
    public static void setUp(String str) {
        System.out.println("Overridden the parent method");
    }

    //METHOD HIDING!!!!!!!
//    @Override --> must be removed if the method became static, also it is no longer extending the method to the parent class
//    public static void setUp() {
//        System.out.println("Overridden the parent method");
//    }

    public void closeUp(){
        System.out.println("closing down!");
    }
}
