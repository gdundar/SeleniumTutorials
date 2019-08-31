package my_practices.interviewQuestions.OOPConcepts;

import cucumber.api.java.an.E;

public class FinalFinallyFinalize {

    //FINAL method in inheritance
    //if any method is labeled as final in the parent class, you can NOT inherit that method!
    // INHERITANCE is prevented in this way! In child method we can not call the same method via inheritance
    //Also it prevents overriding


    //FINAL in var -> becomes constant value
    public static void main(String[] args) {
        final int i =10;
        //i=5; can NOT reassign any value to the final var
        System.out.println(i);
        test();

        //finalize gc() - see bottom
        FinalFinallyFinalize fff = new FinalFinallyFinalize();
        fff= null;
        System.gc();
    }

    //FINALLY
    public static void test(){
        try{
            System.out.println("Try block");
            throw new RuntimeException();
        }catch(Exception e){
            System.out.println("Catch block");
            e.printStackTrace();
        }
        //printed no matter WHAT!
        finally {
            System.out.println("Finally block");
        }
    }


    //FINALIZE - garbage collector of jvm will collect the null pointer objects to free the memory for future.
    public void finalize(){
        System.out.println("Finalize method called automatically");

    }
}
