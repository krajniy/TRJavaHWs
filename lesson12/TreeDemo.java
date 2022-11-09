package TRJavaHWs.lesson12;

public class TreeDemo {
    public static void main(String[] args) {
        TreeImpl<Integer, String> myTree = new TreeImpl<>();
        myTree.put(15, "fifteen");
        myTree.put(1, "one");
        myTree.put(2, "two");
        myTree.put(3, "three");
        myTree.put(40, "fourty");
        myTree.put(2, "twotwo");
        myTree.put(4, "four");
        myTree.put(70, "seventy");

        System.out.println(myTree.getEntry(40));
        System.out.println(myTree.get(2));
        System.out.println(myTree.size());

        TreeImpl.Iterator<Integer, String> iterator = myTree.iterator();

        System.out.println(iterator.nodes);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
