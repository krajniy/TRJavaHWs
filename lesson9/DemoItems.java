package TRJavaHWs.lesson9;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoItems {
    public static void main(String[] args) {
        Item milk = new Item("Milk", 100, 10);
        Item cheese = new Item("Cheese", 250, 8);
        Item chocolate = new Item("Choko", 90, 9);
        Item banana = new Item("Banana", 90, 7);
        Item yogurt = new Item("Yogurt", 1000, 3);


        Category milkGoods = new Category(List.of(milk, cheese, yogurt), "Milk Products");
        Category sweetFood = new Category(List.of(cheese, chocolate, banana), "Sweet food");


        printByPrice(milkGoods);
        printSortedByName(sweetFood);
        printByRating(sweetFood);


    }

    public static void printByPrice(Category category){
        List<Item> items = category.getItems();
        Comparator priceComparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getPrice()-o2.getPrice();
            }
        };
        Collections.sort(items, priceComparator);
        System.out.println(items);
    }
    public static void printSortedByName(Category category){
        List<Item> items = category.getItems();
        Comparator nameComparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(items, nameComparator);
        System.out.println(items);
    }
    public static void printByRating(Category category){
        List<Item> items = category.getItems();
        Comparator ratingComparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getRating()-o2.getRating();
            }
        };
        Collections.sort(items, ratingComparator);
        System.out.println(items);
    }
}
