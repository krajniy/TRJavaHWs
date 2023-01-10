package TRJavaHWs.lesson26;

import java.util.Arrays;
import java.util.Random;

public class Classwork {
    public static void main(String[] args) {
        int[] array = new int[100_000_000];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        createThread(1, array);
        createThread(2, array);
        createThread(5, array);
        createThread(10, array);
        createThread(50, array);
        createThread(100, array);


    }

    public static void createThread(int n, int[] arr){

        int step = arr.length / n;
        int start = 0;

        for (int i = 0; i < n -1; i++) {
            int[] tmp = new int[step+1];
            System.arraycopy(arr, start, tmp, 0, step +1);
            new Thread(() -> {
                System.out.println(Arrays.stream(tmp).max().getAsInt());
                System.out.println(Arrays.stream(tmp).min().getAsInt());
            }).start();
            start+=step;
        }


    }

}


