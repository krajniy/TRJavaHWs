package TRJavaHWs.lesson4Practice;

import java.util.Arrays;

public class ArrayInsertion {
    public static void main(String[] args) {

        int[] arrayToInsert = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] inserted = insert(arrayToInsert, 3, 5);
        System.out.println(Arrays.toString(inserted));

    }

    public static int[] insert(int[] array, int position, int value) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < position; i++) {
            result[i] = array[i];
        }
        result[position] = value;

        for (int i = position + 1; i < array.length+1; i++) {
            result[i] = array[i - 1];

        }
        return result;
    }
}
