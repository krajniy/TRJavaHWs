package TRJavaHWs.lesson2.eshop;

public class User {
    private String login;
    private String password;
    private Basket basket;

    public User(String login, String password, Basket basket) {
        this.login = login;
        this.password = password;
        this.basket = basket;
    }

    public Basket getBasket() {
        return basket;
    }

}
