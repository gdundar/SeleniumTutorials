package my_practices.interviewQuestions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManupulationOfIteration {

    public static void main(String[] args) {
        List<String> gamesList = new ArrayList<String>();
        gamesList.add("Football");
        gamesList.add("Cricket");
        gamesList.add("Chess");
        gamesList.add("Hocky");
        System.out.println("------------Iterating by passing lambda expression--------------");
        //with lambda expression
        // [ONE argument: s -> sout(s);]
        gamesList.forEach(games -> System.out.println(games));


        //ITERATOR method
        Iterator<String> it = gamesList.iterator();
        while ((it.hasNext())){
            String shows = it.next();
            System.out.println(shows);
        }


        //forEachRemaining method
        it = gamesList.iterator();
        it.forEachRemaining(shows -> {
            System.out.println(shows);
        });


        //foreach loop
        for(String shows : gamesList){
            System.out.println(shows);
        }


        //for loop iteration
        for(int i=0; i< gamesList.size(); i++){
            System.out.println(gamesList.get(i));
        }
    }
}
