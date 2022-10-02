package TRJavaHWs.lesson2;

public class Main {
    public static void main(String[] args) {
        Cat whiteCat = new Cat(false, "fish", 4);
        Cat blackCat = new Cat(false, "mice", 4, "black");

        System.out.println(blackCat.getColor() + " cat has " + blackCat.getNoOfLegs() + " legs. " +
                "It's " + blackCat.isVegetarian() + " that he is vegetarian, so he eats " + blackCat.getEats());





    }
}
