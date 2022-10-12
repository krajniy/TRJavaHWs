package TRJavaHWs.lesson5;

import java.util.ArrayList;
import java.util.List;

public class FirstLevel {
    public static void main(String[] args) {
        /*
    1.у вас есть список строковых значений, и вы должны вернуть список со всеми этими строковыми значениями в нижнем регистре
    (или в верхнем регистре)
    2.у вас есть список значений int и вы должны вернуть список, каждое значение которого умножается на 2
    3.у вас есть список значений String , и вы должны вернуть список длины каждого из этих значений String .
         */

//        1
        List<String> stringList = new ArrayList<>();
        stringList.addAll(List.of("у вас есть список строковых значений и вы должны вернуть список со всеми этими строковыми значениями в нижнем регистре или в верхнем регистре".split(" ")));
        System.out.println(changeCase(stringList));
        System.out.println(changeCase(changeCase(stringList)));

//        2
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        System.out.println(doubledValues(integerList));

//        3
        System.out.println(sizesOfStrings(stringList));

    }

    public static List<String> changeCase(List<String> list) {
        List<String> result = new ArrayList<>();
        list.forEach(e -> {
            if (e.equals(e.toUpperCase())) {
                result.add(e.toLowerCase());
            } else {
                result.add(e.toUpperCase());
            }
        });
        return result;
    }

    public static List<Integer> doubledValues(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        list.forEach(e -> {
            result.add(e * 2);
        });
        return result;
    }

    public static List<Integer> sizesOfStrings(List<String> strings){
        List<Integer> result = new ArrayList<>();
        for (String st : strings){
            result.add(st.length());
        }
        return result;
    }
}
