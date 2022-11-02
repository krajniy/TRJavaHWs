package TRJavaHWs.lesson9.hw;

import javax.naming.AuthenticationException;
import java.util.List;

public class DemoShop {
    public static void main(String[] args) throws AuthenticationException {
        Category shampoos = new Category(List.of(
                new Item("Wella", 24.47, 4.7),
                new Item("Pantene Pro-V", 3.45, 4.7),
                new Item("Head & Shoulders", 8.95, 4.4)
        ), "Shampoos");
        Category skin = new Category(List.of(
                new Item("Bi-Oil", 14.38, 4.5),
                new Item("Garnier Vitamin C", 11.95, 4.2),
                new Item("Green Mask Stick", 9.98, 4.8)
        ), "Skin Care");
        shampoos.sortByPrice();
        skin.sortByRating();
        shampoos.reverseSort();

        User user = User.login();
        Shop.enterShop(user);




    }
}
