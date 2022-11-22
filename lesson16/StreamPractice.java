package TRJavaHWs.lesson16;

import java.util.Arrays;
import java.util.List;

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(oddSum(list));
        System.out.println(oddSumStream(list));

        System.out.println(countOccurrences(List.of("a", "b", "a", "c", "a", "d", "s", "x", "a"), "a"));
        System.out.println(findMin(list));
        System.out.println(findMax(list));
    }

    public static int oddSum(List<Integer> list){
        int sum = 0;
        for (Integer i : list) {
            if (i % 2 == 1){
                sum += i;
            }
        }
        return sum;
    }

    public static int oddSumStream(List<Integer> list){
        return list.stream()
                .filter(e -> e % 2 == 1)
                .reduce(Integer::sum).get();
    }


    public static int countOccurrences(List<String> list, String word){
        return (int) list.stream()
                .filter(word::equals)
                .count();
    }

    public static int findMin(List<Integer> list){
        return list.stream()
                .min(Integer::compareTo)
                .get();

    }

    public static int findMax(List<Integer> list){
        return list.stream()
                .max(Integer::compareTo)
                .get();

    }


}
