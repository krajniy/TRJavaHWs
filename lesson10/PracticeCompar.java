package TRJavaHWs.lesson10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PracticeCompar {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>(List.of(
                        new User("AAA", 25),
                        new User("BBB", 25),
                        new User("AAA", 35),
                        new User("SSS", 2)));
        Collections.sort(list);
        System.out.println(list);

    }
}
