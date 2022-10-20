package TRJavaHWs.lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Practice7 {

    public static void main(String[] args) {

        int[] arr = {1, 6, 9, 2, 11};
        System.out.println(javaIterator(5, 8, arr));


    }

    static ArrayList<Integer> javaIterator(int n, int k, int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = Arrays.stream(arr).iterator();
        while (iterator.hasNext()) {
            int l = iterator.next();
            if (l >= k) {

            result.add(l);
            }
        }

        result.sort(Comparator.comparingInt(o -> o));

        return result;

    }
}
