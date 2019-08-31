package my_practices.interviewQuestions.OOPConcepts;

public class BankBank extends Bank{

    //BANK object can NOT be created because it is an ABSTRACT class
    @Override
    public void loan() {
        System.out.println("Bank of America Credit");
    }


}
