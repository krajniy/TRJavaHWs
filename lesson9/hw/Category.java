package TRJavaHWs.lesson9.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Category {
    private List<Item> items = new ArrayList<>();
    private String name;

    public Category(List<Item> items, String name) {
        this.items.addAll(items);
        this.name = name;
        Shop.addCategory(this);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "{" +
                "items=" + items +
                '}';
    }

    public void printAllItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void sortByPrice() {
        Collections.sort(items, byPrice);
    }

    public void sortByRating() {
        Collections.sort(items, byRating);
    }

    public void sortByName() {
        Collections.sort(items, byName);
    }
    public void reverseSort(){
        Collections.reverse(items);
    }

    Comparator byPrice = new Comparator<Item>() {
        @Override
        public int compare(Item i1, Item i2) {
            return (int) (i1.getPrice() * 10 - i2.getPrice() * 10);
        }
    };
    Comparator byName = new Comparator<Item>() {
        @Override
        public int compare(Item i1, Item i2) {
            return i1.getName().compareTo(i2.getName());
        }
    };
    Comparator byRating = new Comparator<Item>() {
        @Override
        public int compare(Item i1, Item i2) {
            return (int) (i1.getRating() * 10 - i2.getRating() * 10);
        }
    };

}
