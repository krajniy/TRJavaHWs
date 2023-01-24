package TRJavaHWs.lesson30;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PracticeThreads {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

//        for (int i = 0; i < s.length(); i++) {
//            int finalI = i;
//            Thread t = new Thread(()->{
//                System.out.println(s.charAt(finalI));
//            });
//            t.start();

//            t.join();


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future[] futures = new Future[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int finalI = i;
            executorService.submit(() -> {
                System.out.println(s.charAt(finalI));
            });
        }

        executorService.shutdown();


    }
}

