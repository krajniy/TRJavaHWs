package TRJavaHWs.lesson9.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    public static List<Category> categories = new ArrayList<>();

    public static void addCategory(Category category){
        categories.add(category);
    }
    public static void printAll(){
        for (Category category : categories){
            System.out.println(category);
        }
    }

    public static void enterShop(User user){
        System.out.println("Input your request in format: " + "\n" +
                "CATALOG " + "to show all categories" + "\n" +
                "CATEGORY + category name (e.g. category Shampoos) " + "to show items in the category" + "\n" +
                "ADD name of item (e.g. ADD Bi-Oil) " + "to add item to basket" + "\n" +
                "BUY " + "to buy items in your basket and clear the basket" + "\n" +
                "BASKET " + "to show the basket" + "\n" +
                "EXIT " + "to exit shop");

        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Evaluator evaluator = new Evaluator();
        try {

        while (scanner.hasNext()){
            evaluator.evaluate(parser.parse(scanner.nextLine()), user);
        }
        } catch (IllegalArgumentException e){
            System.out.println("Wrong request!");
        }


    }

}
