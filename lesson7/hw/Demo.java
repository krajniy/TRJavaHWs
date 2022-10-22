package TRJavaHWs.lesson7.hw;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Demo {
    public static void main(String[] args) {

        System.out.println("Создать лист, наполнить его 10М> элементами");
        List<Integer> list = new LinkedList<>();
        measureTime(() ->
                fillList(list));
        System.out.println("Внутри тела кладем i- тый элемент в переменную temp");
        measureTime(() ->
                putItoTemp(list));
        System.out.println("Перебрать for-each loop");
        measureTime(() ->
                foreach(list));
        System.out.println("classic for и вызываем list.size() для каждой итерации");
        measureTime(() ->
                classicFor(list));
        System.out.println("classic for, но list.size() определяем в переменную");
        measureTime(() ->
                classicForVar(list));
        System.out.println("classic for, list.size() определяем в переменную, перебираем с конца (i--)");
        measureTime(() ->
                classicForVarDesc(list));
        System.out.println("используя Itertor");
        measureTime(() ->
                iteration(list));
        System.out.println("используя ListIterator");
        measureTime(() ->
                listIteration(list));


    }

    public static void fillList(List<Integer> list) {
        for (int i = 0; i < 100_000; i++) { // на 10М оооочень долго отрабатывает, в целях демонстрации сократила
            list.add(i);
        }
    }

    public static <T> void putItoTemp(List<T> list) {
        T tmp;
        for (int i = 0; i < list.size(); i++) {
            tmp = list.get(i);
        }
    }

    public static <T> void foreach(List<T> list) {
        for (T l : list) {

        }
    }

    public static <T> void classicFor(List<T> list) {
        for (int i = 0; i < list.size(); i++) {

        }
    }

    public static <T> void classicForVar(List<T> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

        }
    }

    public static <T> void classicForVarDesc(List<T> list) {
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {

        }
    }

    public static <T> void iteration(List<T> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    public static <T> void listIteration(List<T> list) {
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    public static void measureTime(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long res = System.currentTimeMillis() - start;
        System.out.println("Затраченное время: " + res + " ms"
        );
    }

}
