package TRJavaHWs.lesson10.hw;

import java.util.*;

public class MyDeque<E> extends ArrayList implements Deque {
    /*
    Разработать реализацию интерфейса Deque на основе ArrayList
    (public class MyDeque extends ArrayList implements Deque)
    */


    public MyDeque() {
        super();
    }


    @Override
    public void addFirst(Object o) {
            super.add(0, o);
    }

    @Override
    public void addLast(Object o) {
        super.add(o);

    }

    @Override
    public boolean offerFirst(Object o) {
        super.add(0, o);
        return true;
    }

    @Override
    public boolean offerLast(Object o) {
        if (this.isEmpty()){
            super.add(0);
        } else
            super.add(this.size() - 1, o);
        return true;
    }

    @Override
    public Object removeFirst() {
        return super.remove(0);
    }

    @Override
    public Object removeLast() {
        if (this.size()>0){
            Object o = this.get(this.size() - 1);
            super.remove(this.size() - 1);
            return o;
        } else throw new IndexOutOfBoundsException();

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
        return super.get(0);
    }

    @Override
    public Object getLast() {
        Object o;
        if (this.isEmpty()){
            o = super.get(0);
            super.get(0);
        } else{
            o = super.size()-1;
            super.get(super.size() - 1);}
        return o;

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
        return super.remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        int lastIndex = super.lastIndexOf(o);
        if (lastIndex >= 0) {
            super.remove(lastIndex);
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
        return super.remove(0);
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
