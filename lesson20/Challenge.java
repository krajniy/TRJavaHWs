package TRJavaHWs.lesson20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class Challenge {
     public static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 1_000_000; i++) {
            put(random.nextInt());
        }

        for (int i = 0; i < 100; i++) {

        System.out.println(Arrays.toString(top()));
        }



    }

    static void put(int a){
        set.add(a);

    }

    static int[] top(){
        return set.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .mapToInt(value -> value)
                .toArray();



    }
}
