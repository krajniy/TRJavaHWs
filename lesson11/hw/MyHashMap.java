package TRJavaHWs.lesson11.hw;

import java.util.*;

public class MyHashMap<K, V> {
    /*
    Напишите простую реализацию HashMap на основе динамического массива.
    Для этого вам потребуется реализовать класс Node, где будет храниться ключ и значений
    и метод, который будет искать нужный индекс массива через hashcode ключа и размер массива.
    Стоить учесть, что при увеличении размера массива нужно провесить рехэшинг
    (перезаписать все существующие элементы массива на новые позиции, так как изменился размер).
    Если этого не сделать, поиск по индексам будет работать некорректно.
    В рамках данного задания вам не нужно волноваться о потенциальных коллизиях
     */

    int size = 0;
    float threshold;
    Node<K, V>[] table;
    int capacity;

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public MyHashMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
        threshold = table.length * DEFAULT_LOAD_FACTOR;
        this.capacity = table.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash;
    }

    private int getIndex(K key) {
        return hash(key) % table.length;

    }

    public V put(K key, V value) {
        if (size + 1 == threshold) {
            enlargeMap();
        }

        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(hash(key), key, value);
        if (table[index] == null) {
            table[index] = newNode;
            size++;
            return null;
        } else {
            Node<K, V> head = table[index];
            while (head.next != null) {
                if (head.getKey().equals(key)) {
                    V oldVal = head.getValue();
                    head.value = value;
                    return oldVal;
                }
                head = head.next;
            }
            if (head.getKey().equals(key)) {
                V oldVal = head.getValue();
                head.value = value;
                return oldVal;
            }
            head.next = newNode;
            size++;

            return null; // т.к. не рассматриваем коллизии
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = table[index];
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = table[index];
        Node<K, V> dummy = new Node<>(0, null, null);
        dummy.next = head;
        Node<K, V> prev = dummy;
        V result = null;
        while (head != null) {
            if (head.getKey().equals(key)) {
                result = head.getValue();
                prev.next = head.next;
                table[index] = dummy.next;
                size--;
                break;
            }
            prev = head;
            head = head.next;
        }
        return result;
    }


    private void enlargeMap() {
        Node<K, V>[] newTable = new Node[this.capacity * 2];
        List<Node<K, V>> list = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            Node<K, V> head = table[i];
            while (head != null) {
                list.add(table[i]);
                head = head.next;
            }
        }
        table = newTable;
        threshold = table.length * DEFAULT_LOAD_FACTOR;
        capacity = table.length;
        size = 0;

        list.forEach(e -> put(e.key, e.value));


    }

    @Override
    public String toString() {
        return
                Arrays.toString(Arrays.stream(table).filter(Objects::nonNull).toArray());
    }

    class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;


        }


        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

}
