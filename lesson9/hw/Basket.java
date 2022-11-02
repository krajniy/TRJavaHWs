package TRJavaHWs.lesson9.hw;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> itemsInBasket = new ArrayList<>();

    public Basket(List<Item> items) {
        this.itemsInBasket.addAll(items);
    }

    public Basket() {
    }

    public void addToBasket(Item item){
        this.itemsInBasket.add(item);
    }

    public boolean buyAll(){
        if (itemsInBasket.isEmpty()){
            System.out.println("Nothing in basket!");
            return false;
        } else {

        double totalCost = 0;
        for (Item item : itemsInBasket){
            totalCost += item.getPrice();
        }
        System.out.println("You have paid: " + totalCost);
        System.out.println("You have bought: ");
        for (Item item : itemsInBasket){
            System.out.println(item.getName());
        }
        itemsInBasket.clear();
        return true;
        }
    }

    @Override
    public String toString() {
        return "Basket{" +
                "itemsInBasket=" + itemsInBasket +
                '}';
    }
}
