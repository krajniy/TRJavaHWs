package TRJavaHWs.lesson10.hw;

import java.util.*;

public class MyDeque<E> extends ArrayList implements Deque {
    /*
    Разработать реализацию интерфейса Deque на основе ArrayList
    (public class MyDeque extends ArrayList implements Deque)
    */

    private ArrayList<Object> list;

    public MyDeque() {
        list = new ArrayList<>();
    }


    @Override
    public void addFirst(Object o) {
        list.add(0, o);

    }

    @Override
    public void addLast(Object o) {
        list.add(o);

    }

    @Override
    public boolean offerFirst(Object o) {
          list.add(0, o);
        return true;
    }

    @Override
    public boolean offerLast(Object o) {
        list.add(list.size() - 1, o);
        return true;
    }

    @Override
    public Object removeFirst() {
        return list.remove(0);
    }

    @Override
    public Object removeLast() {
        return list.remove(list.size() - 1);
    }

    @Override
    public Object pollFirst() {
        Object e = getFirst();
        removeFirst();
        return e;
    }

    @Override
    public Object pollLast() {
        Object e = getLast();
        removeLast();
        return e;
    }

    @Override
    public Object getFirst() {
        return list.get(0);
    }

    @Override
    public Object getLast() {
        return list.get(list.size() - 1);
    }

    @Override
    public Object peekFirst() {
        return getFirst();
    }

    @Override
    public Object peekLast() {
        return getLast();
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        int lastIndex = list.lastIndexOf(o);
        if (lastIndex >= 0) {
            list.remove(lastIndex);
            return true;
        }
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return add(o);
    }

    @Override
    public Object remove() {
        return removeFirst();
    }

    @Override
    public Object poll() {
        return pollFirst();
    }

    @Override
    public Object element() {
        return getFirst();
    }

    @Override
    public Object peek() {
        return peekFirst();
    }

    @Override
    public void push(Object o) {
        addFirst(o);
    }

    @Override
    public Object pop() {
        return removeFirst();
    }

    @Override
    public Iterator descendingIterator() {
        ArrayList<Object> copy;
        copy = new ArrayList<>(this);
        Collections.reverse(copy);
        System.out.println(copy);
        return copy.listIterator();
    }
}
