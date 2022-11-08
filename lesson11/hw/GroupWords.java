package TRJavaHWs.lesson11.hw;

import java.util.*;

public class GroupWords {
    /*
    First level: 1. Сгруппируйте слова с одинаковым набором символов
    Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым уникальным набором
    символов.
    вход: String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
    выход:
    student, students,
    cat, act,
    dog, god,
    flow, wolf
     */

    public static void main(String[] args) {
        String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
        findSameUniqChar(words);
        groupWords(words);

    }

    private static void groupWords(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

//           Object[] chch = Stream.of(s.toCharArray()).distinct().toArray();

            Map<Character, String> sMap = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                sMap.put(chars[i], s);
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, String> pair : sMap.entrySet()){
                sb.append(pair.getKey());
            }

            String str = String.valueOf(sb);
            List<String> list = new ArrayList<>();
            list.add(s);
            List<String> values = map.getOrDefault(str, list);

            if (!values.contains(s)){
                values.add(s);
            }
            map.putIfAbsent(str, values);

        }
        for (Map.Entry<String, List<String>> e : map.entrySet()){
            System.out.println(e.getValue());

        }

    }

    public static void findSameUniqChar(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 1; j < strings.length; j++) {
                if (strings[i].length() == strings[j].length()) {
                    if (primitiveHash(strings[i]) == primitiveHash(strings[j])) {
                        System.out.println(strings[j] + ", " + strings[i]);
                        i++;
                        break;
                    }
                }
                else {
                   //TODO
                    Set<Character> set1 = new TreeSet<>();
                    Set<Character> set2 = new TreeSet<>();
                    for (int k = 0; k < strings[i].length(); k++) {
                        set1.add(strings[i].charAt(k));
                    }
                    for (int k = 0; k < strings[j].length(); k++) {
                        set2.add(strings[j].charAt(k));
                    }
                    if (primitiveHash(strings[i]) == primitiveHash(strings[j])) {
                        System.out.println(strings[i] + ", " + strings[j]);
                        i++;
                        break;
                    }




                }
            }
        }
    }

    public static int primitiveHash(String string) {
        int hash = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            hash += c * 29;
        }
        return hash;
    }

}
