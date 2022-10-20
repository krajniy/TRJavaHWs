package TRJavaHWs.lesson6.HW;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDel {

    public static void deleteEl(List<?> list, int index){
        if (index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        int temp = 0;
        for (Object o : list){
            if (index == temp){
                list.remove(index);
                return;
            } else {
                temp++;
            }
        }
        throw new IllegalArgumentException();

    }
    public static void deleteEl(List<?> list, Object element){
        for (Object o : list){
            if (o.equals(element)){
                list.remove(element);
                return;
            }
        }
        throw new IllegalArgumentException();

    }
}
