package TRJavaHWs.lesson12;

import java.util.*;

public class TreeImpl<K, V> {
    private int size = 0;
    private Node<K, V> root = null;

    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        if (root == null) {
            root = new Node<>(key, value);
            size++;
            return;
        }

        Node<K, V> parent = root;

        while (parent != null) {
            int comparison = node.compareTo(parent);
            if (comparison < 0) {
                node.parent = parent;
                parent = parent.left;

            } else if (comparison > 0) {
                node.parent = parent;
                parent = parent.right;

            } else {
                node.left = parent.left;
                node.right = parent.right;
                node.parent = parent.parent;
                if (parent.parent.left == parent) {
                    parent.parent.left = node;
                } else {
                    parent.parent.right = node;
                }
                return;
            }
        }

        if (node.compareTo(node.parent) < 0) {
            node.parent.left = node;
        } else {
            node.parent.right = node;
        }

        size++;
    }

    public V get(K key) {
        Node<K, V> entry = getEntry(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public Node<K, V> getEntry(K key) {
        Node<K, V> entry = root;
        while (entry != null) {
            if (entry.getKey().hashCode() == key.hashCode()) {
                return entry;
            } else if (entry.getKey().hashCode() - key.hashCode() < 0) {
                entry = entry.right;
            } else {
                entry = entry.left;
            }
        }
        return null;

    }

    public int size() {
        return this.size;
    }

    public Iterator<K, V> iterator() {
        return new Iterator<>(this);

    }


    private static class Node<K, V> implements Comparable<Node<K, V>> {
        private final K key;
        private final V value;

        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> parent) {
            this(key, value);
            this.parent = parent;
        }

        public Node(K key, V value, Node<K, V> parent, Node<K, V> left, Node<K, V> right) {
            this(key, value, parent);
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


        @Override
        public int compareTo(Node<K, V> o) {
            return Integer.compare(this.getKey().hashCode(), o.getKey().hashCode());
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static class Iterator<K, V> {
        Node<K, V> next;
        TreeImpl<K, V> tree;
        List<Node<K, V>> nodes = new ArrayList<>();
        int index = 0;

        private final ArrayDeque<Node<K, V>> stack = new ArrayDeque<>();
        private Node<K, V> node;

        private final Map<Node<K, V>, Boolean> map = new HashMap<>();

        public Iterator(TreeImpl<K, V> tree) {
            this.tree = tree;
            this.next = tree.root;
            this.nodes.addAll(collectAllNodes(next));

            this.node = tree.root;


        }

        private Set<Node<K, V>> collectAllNodes(Node<K, V> next) {
            Set<Node<K, V>> result = new LinkedHashSet<>();
            Node<K, V> tmp = null;
            if (next != null) {
                tmp = next;
                if (next.left != null) {
                    result.addAll(collectAllNodes(next.left));
                }
                if (next.right != null) {
                    result.addAll(collectAllNodes(next.right));
                }
            }
            result.add(tmp);
            return result;

        }

        public Node<K, V> next() {
            return nodes.get(index++);
        }

        public boolean hasNext() {
            return index < nodes.size();
        }

        // Stack version

        public Node<K, V> next2() {
            if (!map.containsKey(node)) {
                map.put(node, node.right == null);
            }

            if (node.left != null && stack.peek() != node) {
                stack.push(node);
                node = node.left;
                return node;
            }

            if ((node.right != null)) {

                if (stack.peek() != node && node.left == null) {
                    stack.push(node);
                }
                if (!map.get(node)) {
                    map.put(node, true);
                    node = node.right;
                    return node;
                }
            }

//            Доработанный вариант
            while (!stack.isEmpty() && map.get(stack.peek())) {
                Node<K,V> tmp  = stack.pop();
                node = stack.peek();
                if (node == null){
                    return tmp;
                }

            }
            return node;
        }

        public boolean hasNext2() {
//            return !stack.isEmpty() || (node.left != null || node.right != null);
            return node != null;

        }


    }

}
