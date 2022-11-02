package TRJavaHWs.lesson9.hw;

import javax.naming.AuthenticationException;
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

     public static User login() throws AuthenticationException {
         System.out.println("Input login and password line by line");
         Scanner scanner = new Scanner(System.in);
         String l = scanner.nextLine();
         String p = scanner.nextLine();
//         scanner.close();

         boolean authorized = authenticate(l, p);

         if (authorized){
         return new User(l, p);

         } else {

             System.out.println("Invalid");
             throw new AuthenticationException();

         }
     }
    private static boolean authenticate(String login, String password) {

        return login != null && validatePassword(password);
    }
    private static boolean validatePassword(String password) {
        return password.length() >= 8;
    }


    public Basket getBasket() {
        return basket;
    }
}
