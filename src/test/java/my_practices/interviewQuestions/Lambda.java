package my_practices.interviewQuestions;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnoreType;

import java.util.ArrayList;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);

        arrL.forEach(n -> System.out.println(n));
        arrL.forEach((num) -> System.out.println(num));

        arrL.forEach(n -> { if (n % 2 == 0) System.out.println(n);});


        ///Example
        List<String> list = new ArrayList<String>();
        list.add("Rick");
        list.add("Negan");
        list.add("Daryl");
        list.add("Glenn");
        list.add("Carl");
        list.forEach((names) -> System.out.println(names));



    }


}