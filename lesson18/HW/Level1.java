package TRJavaHWs.lesson18.HW;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Stream;

public class Level1 {
    public static void main(String[] args) {
        //TODO:
//          First level: 1. Написать программу, которая, используя сканнер,
//          считытвает из консоли пары значений. На основе этих значений создается HashMap,
//          типизированный типами этих значений, затем туда добавляются элементы.
//          Любые значения в парах могут принимать типы Integer, String и Double
//          (Возможны вфриации String, String или Integer, Integer)

        Scanner scanner = new Scanner(System.in);
        String[] keyAndValue = new String[2];
        String regInt = "^[0-9]*$";
        String regDouble = "^[0-9\\.]*$";
        String regStr = "^[a-zA-Z]*?$";
        HashMap<?, ?> map;

        if (scanner.hasNext()) {
            keyAndValue[0] = scanner.next();
        }
        if (scanner.hasNext()) {
            keyAndValue[1] = scanner.next();
        }

        try {
            map = getHashMap(scanner, keyAndValue, regInt, regDouble); // основное решение
            Stream.of(map).forEach(System.out::println); // проверка наполнения
            for (Map.Entry<?, ?> entry : map.entrySet()) { // проверка типизации
                System.out.println(entry.getKey().getClass());
                System.out.println(entry.getValue().getClass());
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Be careful with double");
        }

    }

    private static HashMap<?, ?> getHashMap(Scanner scanner, String[] keyAndValue, String regInt, String regDouble) {
        HashMap<?, ?> map;
        if (keyAndValue[0].matches(regInt) && keyAndValue[1].matches(regInt)) {
            map = integerHashMap(keyAndValue, scanner);
        } else if (keyAndValue[0].matches(regInt) && keyAndValue[1].matches(regDouble)) {
            map = integerKeyDoubleValHashMap(keyAndValue, scanner);
        } else if (keyAndValue[0].matches(regDouble) && keyAndValue[1].matches(regDouble)) {
            map = doubleHashMap(keyAndValue, scanner);
        } else if (keyAndValue[0].matches(regDouble) && keyAndValue[1].matches(regInt)) {
            map = doubleKeyIntegerValHashMap(keyAndValue, scanner);
        } else if (keyAndValue[0].matches(regInt)) {
            map = integerKeyStringValHashMap(keyAndValue, scanner);
        } else if (keyAndValue[0].matches(regDouble)) {
            map = doubleKeyStringValHashMap(keyAndValue, scanner);
        } else if (keyAndValue[1].matches(regInt)) {
            map = stringKeyIntegerValHashMap(keyAndValue, scanner);
        } else if (keyAndValue[1].matches(regDouble)) {
            map = stringKeyDoubleValHashMap(keyAndValue, scanner);
        } else {
            map = abstrMap(keyAndValue, scanner);
        }
        return map;
    }

    public static <K, V> HashMap<K, V> abstrMap(Object[] objects, Scanner scanner) {
        HashMap<K, V> map = new HashMap<>();
        map.put((K) objects[0], (V) objects[1]);
        while (scanner.hasNext()) {
            K key = (K) scanner.next();
            if (key.toString().equals("-1")) {
                scanner.close();
                break;
            }
            V value = (V) scanner.next();
            map.put(key, value);
        }

        return map;

    }

    public static HashMap<Integer, Integer> integerHashMap(String[] objects, Scanner scanner) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(Integer.parseInt(objects[0]), Integer.parseInt(objects[1]));
        while (scanner.hasNextInt()) {
            int key = scanner.nextInt();
            if (key == -1) {
                scanner.close();
                break;
            }
            int value = scanner.nextInt();
            map.put(key, value);
        }
        return map;
    }

    public static HashMap<Double, Double> doubleHashMap(String[] objects, Scanner scanner) throws NumberFormatException {
        HashMap<Double, Double> map = new HashMap<>();
        map.put(Double.parseDouble(objects[0]), Double.parseDouble(objects[1]));
        while (scanner.hasNext()) {
            double key = Double.parseDouble(scanner.next());
            if (key == -1) {
                scanner.close();
                break;
            }
            double value = Double.parseDouble(scanner.next());
            map.put(key, value);
        }
        return map;
    }

    public static HashMap<Integer, Double> integerKeyDoubleValHashMap(String[] objects, Scanner scanner) throws NumberFormatException {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(Integer.parseInt(objects[0]), Double.parseDouble(objects[1]));
        while (scanner.hasNext()) {
            int key = scanner.nextInt();
            if (key == -1) {
                scanner.close();
                break;
            }
            double value = Double.parseDouble(scanner.next());
            map.put(key, value);
        }
        return map;
    }

    public static HashMap<Double, Integer> doubleKeyIntegerValHashMap(String[] objects, Scanner scanner) throws NumberFormatException {
        HashMap<Double, Integer> map = new HashMap<>();
        map.put(Double.parseDouble(objects[0]), Integer.parseInt(objects[1]));
        while (scanner.hasNext()) {
            double key = Double.parseDouble(scanner.next());
            if (key == -1) {
                scanner.close();
                break;
            }
            int value = scanner.nextInt();
            map.put(key, value);
        }
        return map;
    }

    public static HashMap<Integer, String> integerKeyStringValHashMap(String[] objects, Scanner scanner) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(Integer.parseInt(objects[0]), String.valueOf(objects[1]));
        while (scanner.hasNext()) {
            int key = scanner.nextInt();
            if (key == -1) {
                scanner.close();
                break;
            }
            String value = scanner.next();
            map.put(key, value);
        }
        return map;
    }

    public static HashMap<Double, String> doubleKeyStringValHashMap(String[] objects, Scanner scanner) throws NumberFormatException {
        HashMap<Double, String> map = new HashMap<>();
        map.put(Double.parseDouble(objects[0]), String.valueOf(objects[1]));
        while (scanner.hasNext()) {
            double key = Double.parseDouble(scanner.next());
            if (key == -1) {
                scanner.close();
                break;
            }
            String value = scanner.next();
            map.put(key, value);
        }
        return map;
    }

    public static HashMap<String, Integer> stringKeyIntegerValHashMap(String[] objects, Scanner scanner) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(String.valueOf(objects[0]), Integer.parseInt(objects[1]));
        while (scanner.hasNext()) {
            String key = scanner.next();
            if ("-1".equals(key)) {
                scanner.close();
                break;
            }
            int value = scanner.nextInt();
            map.put(key, value);
        }
        return map;
    }

    public static HashMap<String, Double> stringKeyDoubleValHashMap(String[] objects, Scanner scanner) throws NumberFormatException {
        HashMap<String, Double> map = new HashMap<>();
        map.put(String.valueOf(objects[0]), Double.parseDouble(objects[1]));
        while (scanner.hasNext()) {
            String key = scanner.next();
            if ("-1".equals(key)) {
                scanner.close();
                break;
            }
            double value = Double.parseDouble(scanner.next());
            map.put(key, value);
        }
        return map;
    }
}
