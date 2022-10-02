package TRJavaHWs.lesson2.eshop;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EshopDemo {
    public static void main(String[] args) {
        Category shampoos = new Category("Shampoos", new Good[]{
                new Good("Wella", 24.47, 4.7),
                new Good("Pantene Pro-V", 3.45, 4.7),
                new Good("Herbal Essences", 2.99, 4.6),
                new Good("Head & Shoulders", 8.95, 4.4)
        });

        Category skin = new Category("Skin Care", new Good[]{
                new Good("Bi-Oil", 14.38, 4.5),
                new Good("Hyaluronic Serum", 34.90, 4.3),
                new Good("Garnier Vitamin C", 11.95, 4.2),
                new Good("Green Mask Stick", 9.98, 4.8)
        });

        User user = new User("login", "password", new Basket());
        List<Good> listToBuy = Stream.of(shampoos.getGoods()[0], skin.getGoods()[0]).collect(Collectors.toList());
        user.getBasket().addAllToBasket(listToBuy);
        System.out.println(user.getBasket());

    }
}
