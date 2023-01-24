package TRJavaHWs.lesson30;

import java.util.Scanner;

public class PracticeThreads {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        for (int i = 0; i < s.length(); i++) {
            int finalI = i;
            Thread t = new Thread(()->{
                System.out.println(s.charAt(finalI));
            });
            t.start();
            t.join();


        }
    }
}
