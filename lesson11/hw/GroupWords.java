package TRJavaHWs.lesson11.hw;

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

    }

    public static void findSameUniqChar(String[] strings){
        for (int i = 0; i < strings.length; i++) {
            for (int j = 1; j < strings.length; j++) {
                if (primitiveHash(strings[i]) == primitiveHash(strings[j])){
                    System.out.println(strings[i] + ", " + strings[j]);
                    i++;
                    break;
                }
            }
        }
    }

    public static int primitiveHash(String string){
        int hash = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            hash += c * 29;
        }
        return hash;
    }

}
