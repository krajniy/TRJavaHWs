package TRJavaHWs.lesson13;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LessonDemo {
    public static void main(String[] args) {
        LessonGraph<Integer> graph = new LessonGraph<>();
        //нет метода для добавления первого элемента
        // метод для Node[] не сработает, Node - приватный
        // метод для T[] выкинет исключение

        Integer[] array = {1,2,3,4,5};
        graph.add(17, array);



    }
}
