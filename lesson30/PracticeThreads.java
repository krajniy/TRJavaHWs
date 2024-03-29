package TRJavaHWs.lesson30;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        for (int i = 0; i < s.length(); i++) {
            int finalI = i;
            executorService.submit(() -> {
                System.out.println(s.charAt(finalI));
            });
        }

        executorService.shutdown();


    }
}

