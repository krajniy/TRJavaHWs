package TRJavaHWs.lesson16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(oddSum(list));
        System.out.println(oddSumStream(list));

        System.out.println(countOccurrences(List.of("a", "b", "a", "c", "a", "d", "s", "x", "a"), "a"));
        System.out.println(findMin(list));
        System.out.println(findMax(list));

        System.out.println(sortReverseUnique(List.of("a1", "b5", "c1", "a2", "b4", "c1", "a1")));

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
                .reduce(Integer::sum)
                .get();
    }


    //TODO: написать код через стрим, который будет проверять сколько раз word встречается в list
    public static int countOccurrences(List<String> list, String word){
        return (int) list.stream()
                .filter(word::equals)
                .count();
    }

    //TODO: написать код, который с помощью стримов будет искать наименьший элемент
    public static int findMin(List<Integer> list){
        return list.stream()
                .min(Integer::compareTo)
                .get();
    }

    //TODO: написать код, который с помощью стримов будет искать наибольший элемент
    public static int findMax(List<Integer> list){
        return list.stream()
                .max(Integer::compareTo)
                .get();

    }


    //TODO: написать стрим, который отсортирует коллекцию в обратном порядке и удалит дубликаты
    public static List<String> sortReverseUnique(List<String> list){
        return list.stream().distinct().sorted(String::compareTo).collect(Collectors.toList());
    }


}
