package TRJavaHWs.lesson20;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringPractice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String check = scanner.nextLine();
        scanner.close();

        System.out.println(countEachLetter(check));

    }
    static Map<Character, Integer> countEachLetter(String s){
        Map<Character, Integer> map = new HashMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < alphabet.length(); i++) {
            map.put(alphabet.charAt(i), 0);

        }

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 0){
                map.computeIfPresent(s.charAt(i), (k, v)->v+1);
            }
        }
        return map;

    }
}
