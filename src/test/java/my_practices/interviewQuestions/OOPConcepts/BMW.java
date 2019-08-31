package my_practices.interviewQuestions.OOPConcepts;

public class BMW implements Car{

    //CAR object can NOT be created because it is an INTERFACE class
    //NO OBJECT INTENTIATING FOR ABSTRACT AND INTERFACE!!!
    @Override
    public void start() {
        System.out.println("BMW start");
    }

    @Override
    public void stop() {
        System.out.println("BMW stop");
    }

    @Override
    public void refuel() {
        System.out.println("BMW refuel");
    }
}
