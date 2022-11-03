package TRJavaHWs.lesson10.hw;

import TRJavaHWs.lesson9.hw.Item;

import java.util.Iterator;

public class Demo {
    /*
    First level: Написать реализацию Stack, не используя стандартные классы java.util.collection.
    Stack должен иметь 4 основных метода (push, pop, peek, size) и работать на основе массива.
    Стоит учесть необходимость динамически менять размер массива при добавлении новых элементов.
    Разработать реализацию интерфейса Deque на основе ArrayList
    (public class MyDeque extends ArrayList implements Deque)
     */

    public static void main(String[] args) {
        MyStack stack = new MyStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peak());
        stack.push(77);
        System.out.println(stack);
        System.out.println(stack.size());

        MyDeque deque = new MyDeque();
        deque.add(5);
        deque.add(4);
        deque.add(7);
        deque.add(9);
        deque.add(10);
        deque.add(8);

        Iterator iterator = deque.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
