package TRJavaHWs.lesson18.HW;

import java.util.HashMap;
import java.util.Scanner;

public class Level2 {
    public static void main(String[] args) {
        //TODO:
//          * Отдельно написать модификацию программы, которая будет читать значения
//          в формате строки (nextLine) в формате "key = value" без кавычек.
//          Ключи могут быть только строками, а значения только integer

        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String reg = ".*?=\\s?\\d*?";

        String pair;
        String[] pairArgs = new String[2];
        while (scanner.hasNextLine()){
            pair = scanner.nextLine();
            if ("".equals(pair)){
                break;
            }
            if (pair.matches(reg)){
                pairArgs = pair.split("=");
                map.put(pairArgs[0].trim(), Integer.parseInt(pairArgs[1].trim()));
            } else throw new IllegalArgumentException();
        }

        System.out.println(map);

    }
}
