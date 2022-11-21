package TRJavaHWs.lesson14;

public class HW14Main {
    public static void main(String[] args) {
        /*
        Написать интерфейс Класс Button с методом void click(ButtonAction action)
        Написать функциональный интерфейс ButtonAction с методом performAction
        Создать Button и вызвать у него метод click 2 раза -- с лямбдой и с method refrence
        (для этого нужно будет создать реализацию интерфейса ButtonAction)
         */

        Button button = new Button() {
            @Override
            public void click(ButtonAction action) {
                action.performAction();
            }
        };

        Button button1 = action -> action.performAction();
        Button button2 = ButtonAction::performAction;




//        Button b = new Button(); // через класс
//        b.click(() -> System.out.println("Click!"));

    }
}
