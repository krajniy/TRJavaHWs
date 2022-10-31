package TRJavaHWs.lesson9.hw;

import java.util.Scanner;

public class User {
    private String login;
    private String password;
    private Basket basket;

    private User(String login, String password) {
        this.login = login;
        this.password = password;
        this.basket = new Basket();
    }

     public static User login(){
         System.out.println("Input login and password line by line");
         Scanner scanner = new Scanner(System.in);
         String l = scanner.nextLine();
         String p = scanner.nextLine();
//         scanner.close();
         return new User(l, p);
     }


    public Basket getBasket() {
        return basket;
    }
}
