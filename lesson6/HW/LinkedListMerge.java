package TRJavaHWs.lesson6.HW;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class LinkedListMerge {

    public static <T> LinkedList<T> mergeWithDuplicates (LinkedList<T> first, LinkedList<T> second){
        if (first == null) return second;
        if (second == null) return first;

        LinkedList<T> result = new LinkedList<>();
        result.addAll(first);
        result.addAll(second);
        return result;
    }


    public static <T> LinkedList<T> mergeWithOutDuplicates (LinkedList<T> first, LinkedList<T> second){
        LinkedList<T> result = mergeWithDuplicates(first, second);
        TreeSet<T> temp = new TreeSet<>(result);
        return new LinkedList<T>(temp);

    }
}
