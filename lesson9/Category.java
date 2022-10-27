package TRJavaHWs.lesson9;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private List<Item> items = new ArrayList<>();
    private String name;

    public Category(List<Item> items, String name) {
        this.items.addAll(items);
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}
