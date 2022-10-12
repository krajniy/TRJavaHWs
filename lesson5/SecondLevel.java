package TRJavaHWs.lesson5;

import java.util.*;

public class SecondLevel {
    public static void main(String[] args) {
    /*1.у вас есть список значений String и вы должны вернуть список со всеми значениями String определенной длины
    2.у вас есть список значений int и вы должны вернуть список, содержащий только нечетные числа
    3.у вас есть список значений String , и вы должны вернуть список этих значений без каких-либо дубликатов.
    4.упражнение для списков массивов Удалить слишком короткие слова*/

//        1
        List<String> stringList = new ArrayList<>();
        stringList.addAll(List.of("у вас есть список значений String и вы должны вернуть список со всеми значениями String определенной длины".split(" ")));
        System.out.println(preciseLength(stringList, 2)); //вы, со

//        2
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        System.out.println(oddsOnly(integerList));

//        3
        Set<String> stringSet = new HashSet<>(stringList);
        System.out.println(stringSet); // :)

//        4
        System.out.println(stringList);
        deleteLeastLengthWords(stringList);
        System.out.println(stringList);
    }

    public static List<String> preciseLength(List<String> strings, int length) {
        List<String> result = new ArrayList<>();
        strings.forEach(s -> {
            if (s.length() == length) {
                result.add(s);
            }
        });
        return result;
    }

    public static List<Integer> oddsOnly(List<Integer> integers) {
        List<Integer> result = new ArrayList<>();
        integers.forEach(i -> {
            if (i % 2 != 0) {
                result.add(i);
            }
        });
        return result;
    }

    public static void deleteLeastLengthWords(List<String> strings){
        Collections.sort(strings, (o1, o2) -> o2.length()-o1.length());
        int minLength = strings.get(strings.size()-1).length();
        for (int i = strings.size()-1; i > 0 ; i--) {
            if (strings.get(i).length()>minLength){
                break;
            } else {
                strings.remove(strings.get(i));
            }
        }
    }
}
