package TRJavaHWs.lesson13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<T> {
    private Node<T> root;
    private final Map<T, Node<T>> map = new HashMap<>();

    public Node<T> getRoot() {
        return root;
    }

    public MyGraph(Node<T> root) {
        this.root = root;
        map.put(root.getValue(), root);
    }

    public void add(T t) {
        Node<T> newNode = new Node<>(t);
        Edge<T> newEdge = new Edge<>(root, newNode);
        Edge<T> newEdgeReflection = new Edge<>(newNode, root);
        newNode.addEdge(newEdgeReflection);
        root.addEdge(newEdge);
        map.put(t, newNode);
    }

    public void add(T t, Node<T> node) {
        if (map.containsKey(node.getValue())) {
            Node<T> newNode = new Node<>(t);
            Edge<T> newEdge = new Edge<>(node, newNode);
            Edge<T> newEdgeReflection = new Edge<>(newNode, node);
            node.addEdge(newEdge);
            newNode.addEdge(newEdgeReflection);
            map.put(t, newNode);
        } else {
            throw new IllegalArgumentException("No such node in this graph");
        }

    }

    public void add(T t, List<Node<T>> nodes) {
        Node<T> newNode = new Node<>(t);
        for (Node<T> n : nodes) {
            Edge<T> newEdge = new Edge<>(newNode, n);
            newNode.addEdge(newEdge);
            n.addEdge(newEdge);
        }
    }

    public Node<T> findNode(T t) {
        return map.get(t);
    }

    public void remove(T t){
        if (findNode(t) != null){
            if (findNode(t) != root){
            Node<T> toRemove = findNode(t);
            toRemove.edges.forEach(e -> e.node2.deleteEdge(toRemove));
            map.remove(t);
            } else {
                if (root.edges.size() > 0){
                    Node<T> newRoot = root.edges.get(0).node2;
                    newRoot.deleteEdge(root);
                    for (int i = 1; i < root.edges.size(); i++) {
                        root.edges.get(i).node2.substituteNeighbor(root, newRoot);
                    }
                    root = newRoot;


                } else {
                    throw new RuntimeException("Can't delete root!");
                }


            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(root);

        root.edges.forEach(e -> sb.append("\n").append("-> ").append(e.node2));

        return sb.toString();
    }

    public static class Node<T> {
        T value;
        List<Edge<T>> edges = new ArrayList<>();

        public T getValue() {
            return value;
        }

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, List<Edge<T>> edges) {
            this.value = value;
            this.edges.addAll(edges);
        }

        public void addEdge(Edge<T> e) {
            edges.add(e);
        }
        public void deleteEdge(Node<T> n){
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).node2 == n){
                    edges.remove(i);
                    return;
                }
            }

        }

        public void substituteNeighbor(Node<T> n1, Node<T> n2){
            for (Edge<T> e : edges){
                if (e.node2 == n1){
                    e.node2 = n2;

                    n2.addEdge(new Edge<>(n2,this));
                }
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", edges=" + edges +
                    '}';
        }
    }

    public static class Edge<T> {
        Node<T> node1;
        Node<T> node2;
        int weight;

        public Edge(Node<T> node1, Node<T> node2) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = 1;
        }

        @Override
        public String toString() {
            return node1.value + " " + node2.value;
        }
    }



}
