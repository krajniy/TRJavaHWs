package TRJavaHWs.lesson9.hw;

import java.util.Map;

public class Evaluator {

    public void evaluate(Map<String, Object> map, User user) {
        switch (Operations.valueOf(map.get("Operation").toString())) {
            case ADD -> {
                int count = 0;
                for (Category category : Shop.categories) {
                    for (Item item : category.getItems()) {
                        if (item.getName().equals(map.get("Item or Category"))) {
                            user.getBasket().addToBasket(item);
                            System.out.println("You've added " + item);
                            count++;
                            break;
                        }
                    }
                }
                if (count == 0) {
                    System.out.println("There is no " + map.get("Item or Category"));
                }
            }
            case BUY -> {
                user.getBasket().buyAll();
            }
            case CATEGORY -> {
                for (Category category : Shop.categories) {
                    if (category.getName().equals(map.get("Item or Category"))) {
                        category.printAllItems();
                    }
                }
            }
            case CATALOG -> Shop.printAll();
            case BASKET -> {
                System.out.println(user.getBasket());
            }
            case EXIT -> System.exit(1);
        }
    }
}
