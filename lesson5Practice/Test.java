package TRJavaHWs.lesson5Practice;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> letters = new ArrayList<>();
        letters.addAll(List.of("ABCD".split("")));
        System.out.println(letters);
        letters.add("E");
        letters.add("H");
        System.out.println("Letters list contains E? " + letters.contains("E"));
        System.out.println("Letters list contains Z? " + letters.contains("Z"));
        System.out.println("Letter at 5th place: " + letters.get(4));
        List<String> tempList = new ArrayList<>();
        System.out.println("tempList is empty? " + tempList.isEmpty());
        System.out.println("First index of D = " + letters.indexOf("D"));
        System.out.println("Last index of D = " + letters.lastIndexOf("D"));
        letters.add(5, "F");
        letters.add(6, "G");
        System.out.println(letters);
        letters.remove("D");
        System.out.println("After removing 'D' letters contains " + letters);
        System.out.println("H removed? " + letters.remove("H") + ". Letters contains " + letters);
        tempList.add("F");
        tempList.add("G");
        System.out.println("list contains " + tempList);
        letters.removeAll(tempList);
        System.out.println(letters);
        tempList.add("A");
        tempList.add("B");
        tempList.add("C");
        letters.retainAll(tempList);
        System.out.println("letters elements after retainAll operation: " + letters);
        System.out.println("letters ArrayList size = " + letters.size());
        System.out.println(letters);





    }
}
