package TRJavaHWs.lesson11;

import java.util.HashMap;
import java.util.Map;

public class FirstInArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 5, 6};
        firstEl(array, 0);

    }

    public static void firstEl(int[] arr, int count) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.put(arr[i], map.getOrDefault(arr[i], 0) + 1) != null) {
                System.out.println("Element is " + arr[i]);
                return;
            }
        }

    }


    public static void mapSearch(int[] arr, int count) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            if (map.get(arr[i]) == count) {
                System.out.println("Element is " + arr[i]);
                return;
            }
        }
    }


    public static void quadraticSearch(int[] arr, int count) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    System.out.println("Element is " + arr[i]);
                    return;
                }
            }
        }
    }
}
