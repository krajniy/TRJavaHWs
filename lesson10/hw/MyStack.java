package TRJavaHWs.lesson10.hw;

import java.util.Arrays;
import java.util.Objects;

public class MyStack <E> {
        /*
    First level: Написать реализацию Stack, не используя стандартные классы java.util.collection.
    Stack должен иметь 4 основных метода (push, pop, peek, size) и работать на основе массива.
    Стоит учесть необходимость динамически менять размер массива при добавлении новых элементов.
     */

    private int size = 0;
    private Object [] array;
    private int defaultCapacity = 10;
    private final double GROWTH_THRESHOLD = .75;
    private final int GROWTH = 2;



    public MyStack() {
        array = new Object [defaultCapacity];

    }

    public MyStack(int defaultCapacity) {
        this.defaultCapacity = defaultCapacity;
        array = new Object [defaultCapacity];

    }

    public MyStack(Object[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.size = array.length;

    }

    public void push(E e){
        if (size >= array.length-GROWTH_THRESHOLD){
            enlargeCapacity();
        }
        array[size] = e;
        size++;
    }

    public E pop(){
        size--;
        E e = (E) array[size];
        array[size] = null;
        return e;
    }

    public E peek(){

        return (E) array[size-1];
    }

    private void enlargeCapacity(){
        defaultCapacity = defaultCapacity*GROWTH+1;
        Object[] copy = new Object[defaultCapacity];
        System.arraycopy(array, 0, copy,  0, array.length);
        array = copy;

    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(array).filter(Objects::nonNull).toArray());
    }
}
