package TRJavaHWs.lesson26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Classwork {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[100_000_000];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        int sleepTime = 3000;

//        createThread(1, array);
//        Thread.sleep(sleepTime);
//        createThread(2, array);
//        Thread.sleep(sleepTime);
//        createThread(5, array);
//        Thread.sleep(sleepTime);
        createThread(10, array);
//        Thread.sleep(sleepTime);
//        createThread(50, array);
//        Thread.sleep(sleepTime);
//        createThread(100, array);


    }

    public static void createThread(int n, int[] arr) {
//        int step = arr.length / n;
//        int start = 0;
//
//        for (int i = 0; i < n -1; i++) {
//            int[] tmp = new int[step+1];
//            System.arraycopy(arr, start, tmp, 0, step +1);
//            new Thread(() -> {
//                System.out.println(n + ":");
//                System.out.println(Arrays.stream(tmp).max().getAsInt());
//                System.out.println(Arrays.stream(tmp).min().getAsInt());
//            }).start();
//            start+=step;
//        }

        List<Future<Integer>> futures = splitThreads(n, arr);
        while (!checkFutures(futures)) {
            System.out.println("Calculating...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int max = futures.stream().mapToInt(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).max().getAsInt();
        System.out.println("Total max: " + max);


    }

    public static boolean checkFutures(List<Future<Integer>> futures) {
        for (Future<Integer> f : futures) {
            if (!f.isDone()) {
                return false;
            }
        }
        return true;
    }

    public static List<Future<Integer>> splitThreads(int n, int[] arr) {
        List<Future<Integer>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(n);


        int step = arr.length / n;
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] tmp = new int[step + 1];
            System.arraycopy(arr, start, tmp, 0, step + 1);
            futures.add(executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                return Arrays.stream(tmp).max().getAsInt();
            }));
            start += step;
        }
        executor.shutdown();
        return futures;
    }

}


