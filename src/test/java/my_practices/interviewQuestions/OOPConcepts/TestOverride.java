package my_practices.interviewQuestions.OOPConcepts;

public class TestOverride {

    public static void main(String[] args) {

        ChildOverride childOverride = new ChildOverride();
        childOverride.closeUp();
        childOverride.setUp();

        ParentOverride parentOverride = new ParentOverride();
        parentOverride.setUp();

    }
}