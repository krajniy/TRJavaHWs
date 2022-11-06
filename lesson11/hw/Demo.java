package TRJavaHWs.lesson11.hw;


public class Demo {
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

    Напишите простую реализацию HashMap на основе динамического массива.
    Для этого вам потребуется реализовать класс Node, где будет храниться ключ и значений
    и метод, который будет искать нужный индекс массива через hashcode ключа и размер массива.
    Стоить учесть, что при увеличении размера массива нужно провесить рехэшинг
    (перезаписать все существующие элементы массива на новые позиции, так как изменился размер).
    Если этого не сделать, поиск по индексам будет работать некорректно.
    В рамках данного задания вам не нужно волноваться о потенциальных коллизиях
     */
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(15, "пятнадцать");
        myHashMap.put(16, "шестнадцать");
        myHashMap.put(17, "семнадцать");
        myHashMap.put(15, "не пятнадцать");

        System.out.println(myHashMap.get(15));
        System.out.println(myHashMap.get(16));
        System.out.println(myHashMap.get(17));
        System.out.println(myHashMap.table.length);
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.remove(17));
        System.out.println(myHashMap);
        System.out.println(myHashMap.size());


        myHashMap.put(1, "1");
        myHashMap.put(2, "2");
        myHashMap.put(3, "3");
        myHashMap.put(4, "4");
        myHashMap.put(5, "5");
        myHashMap.put(6, "6");
        myHashMap.put(7, "7");
        myHashMap.put(8, "8");
        myHashMap.put(9, "9");
        myHashMap.put(10, "10");
        myHashMap.put(11, "11");
        myHashMap.put(12, "12");
        myHashMap.put(13, "13");

        System.out.println(myHashMap);
        System.out.println(myHashMap.get(16));
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.capacity);



    }
}
