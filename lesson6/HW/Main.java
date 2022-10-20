package TRJavaHWs.lesson6.HW;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        1. Напишите программу для удаления указанного элемента из связанного списка.
//          Вывод:
//          The Original linked list: [Red, Green, Black, Pink, orange]
//          The New linked list: [Red, Green, Pink, orange]

        LinkedList<String> list = new LinkedList<>();
        list.addAll(List.of("Red", "Green", "Black", "Pink", "Orange"));
        System.out.println(list);
        LinkedListDel.deleteEl(list, 2);
        System.out.println(list);
        LinkedListDel.deleteEl(list, "Pink");
        System.out.println(list);
//        LinkedListDel.deleteEl(list, "Pink"); //check of Exception

//        Напишите программу для замены двух элементов в связанном списке.
//          Вывод:
//          The Original linked list: [Red, Green, Black, Pink, orange]
//          The New linked list after swap: [Black, Green, Red, Pink, orange]

        LinkedList<String> list1 = new LinkedList<>();
        list1.addAll(List.of("Red", "Green", "Black", "Pink", "Orange"));
        System.out.println(list1);
        LinkedListSwap.swap(list1, 0, 2);
        System.out.println(list1);

//        Напишите Jпрограмму для объединения двух связанных списков.
//          Вывод:
//          List of first linked list: [Red, Green, Black, White, Pink]
//          List of second linked list: [Red, Green, Black, Pink]
//          New linked list: [Red, Green, Black, White, Pink, Red, Green, Black, Pink]

        LinkedList<String> merged = LinkedListMerge.mergeWithDuplicates(list, list1);
        System.out.println(merged);
        LinkedList<String> mergedWODupl = LinkedListMerge.mergeWithOutDuplicates(merged, list1);
        System.out.println(mergedWODupl);















    }
}
