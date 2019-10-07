package my_practices.interviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateElement {

    public static void main(String[] args) {

        String names[] = {"Java", "JavaScript", "Python", "Ruby", "Java"};

        for(int i = 0; i < names.length; i++){
            for(int j = i+1; j < names.length; j++){
                if(names[i].equalsIgnoreCase(names[j])){
                    System.out.println(names[i]);
                }
            }
        }

        //using HashSet
        Set<String> store = new HashSet<>();
        for(String name : names){
            if(store.add(name) == false){
                System.out.println("The duplicate element is: " + name);
            }
        }




// Input: [1, 5, 3, 4, 3, 7, 8, 2, 9, 8]
// Output: [3, 8]

        int [] a = {1, 5, 3, 4, 3, 7, 8, 2, 9, 8};
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i]==(a[j])){
                    System.out.print(a[i] + ", ");
                }
            }
        }

    }
}



