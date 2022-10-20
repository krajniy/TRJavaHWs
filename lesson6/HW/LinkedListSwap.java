package TRJavaHWs.lesson6.HW;

import java.util.List;

public class LinkedListSwap {

    public static <T> void swap(List<T> list, int first, int second){
        if (first >= list.size() || second >= list.size()){
            throw new IndexOutOfBoundsException();
        }
        var temp = list.get(first);
        var secVal = list.get(second);
        list.set(first,  secVal);
        list.set(second, temp);
    }

    public static <T> void swap (List<T> list, T first, T second){
        int firstIndx = list.indexOf(first);
        int secIndx = list.indexOf(second);

        if (firstIndx == -1 || secIndx == -1){
            throw new IndexOutOfBoundsException();
        }
        list.set(firstIndx, second);
        list.set(secIndx, first);
    }

}
