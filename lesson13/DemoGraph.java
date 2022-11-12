package TRJavaHWs.lesson13;

public class DemoGraph {
    public static void main(String[] args) {
        MyGraph<Integer> myGraph = new MyGraph<>(new MyGraph.Node<>(23));
        myGraph.add(75);
        myGraph.add(22);
        myGraph.add(33);
        myGraph.add(106, myGraph.getRoot());
        myGraph.add(86, myGraph.findNode(22));


        System.out.println(myGraph);
        System.out.println("--------------");

        System.out.println(myGraph.findNode(106));
        myGraph.remove(23);
        System.out.println("--------------");
        System.out.println(myGraph);





    }
}
