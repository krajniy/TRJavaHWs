package TRJavaHWs.lesson10.hw;

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
        MyStack<Integer> stack = new MyStack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.push(77);
        System.out.println(stack);
        System.out.println(stack.size());

        MyDeque deque = new MyDeque();
        deque.addFirst(5);
        deque.addFirst(4);
        deque.addFirst(7);
        deque.addFirst(9);
        deque.addFirst(10);
        deque.addLast(8);
        deque.addFirst(8);
        deque.add(8);
        deque.offerFirst(17);
        deque.offerLast(8);

        Iterator iterator = deque.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("Size: "+ deque.size());
        System.out.println(deque.peek());
        System.out.println(deque.getLast());
        System.out.println(deque.peekLast());
        System.out.println(deque.offer(59));
        System.out.println(deque.remove());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.element());
        System.out.println(deque.pop());
        System.out.println(deque);
        System.out.println(deque.removeLastOccurrence(8));
        System.out.println(deque.removeFirstOccurrence(8));











    }
}
