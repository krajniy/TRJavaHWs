package TRJavaHWs.lesson22;

import java.util.ArrayList;
import java.util.List;

public class Classwork {
    public static void main(String[] args) {

//TODO:
//       1. Написать метод, который получает на вход список
//       2. Для каждого вызова первого метода, полученную коллекцию нужно разбить по элементам и каждый элемент
//       передать во второй метод, который так же будет типизирован типом коллекции
//       Второй метод должен проверять, является ли число простым, а первый метод должен возвращать количество
//       простых чисел в коллекции

        List<Integer> list = new ArrayList<>(){{
           add(11);
           add(2);
           add(3);
           add(13);
           add(14);
        }};
        System.out.println(numberOfSimple(list));

    }

    public static <T extends Number> int numberOfSimple(List<T> list){
        int counter = 0;
        for (T el : list){
            if (checkSimplicity(el)){
                counter++;
            }


        }
            return counter;


    }

    public static <T  extends Number> boolean checkSimplicity(T element){

            for (int i = 2; i < (Integer) element; i++) {
                if ((Integer) element % i == 0) {
                    return false;
                }

        }
            return true;
    }



}
