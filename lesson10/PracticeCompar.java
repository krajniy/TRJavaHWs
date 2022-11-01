package TRJavaHWs.lesson10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PracticeCompar {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
               list.addAll(List.of(new User("PPP", 25), new User("PPP", 125), new User("QQQ", 55), new User("SSS", 2)));
        Collections.sort(list);
        System.out.println(list);
    }
}
