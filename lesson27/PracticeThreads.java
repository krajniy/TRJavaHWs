package TRJavaHWs.lesson27;

import java.util.Arrays;

public class PracticeThreads {
    //TODO:
    //    Создать 5 потоков, которые будут спать по 10 секунд, причем если поток был разбужен, он должен уйти обратно в сон на оставшееся время
    //    Создать 6й демон-поток, который в бесконечном цикле будет проверять, спят ли основные потоки и менять значение в массиве по индексу на true,
    //    если они спят
    //    Поток main каждые 10мс проверяет состояние массива и будит все спящие потоки

    public static void main(String[] args) {
        boolean[] threadsAreSleeping = new boolean[5];
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {

                long start = System.nanoTime();
                long end = start + 10_000 * 1_000_000L;
                long sleepTime = 10_000;
                while (System.nanoTime() < end) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        sleepTime = (end - System.nanoTime()) / 1000000;
                        System.out.println("Thread was awaken. Time remains: " + sleepTime);
                    }
                }
                System.out.println("Thread execution finished");

            });
            threads[i].start();
        }


        Thread daemon = new Thread(() -> {
            while (true){
                for (int i = 0; i < 5; i++){
                    if (threads[i].getState() == Thread.State.TIMED_WAITING){
                        threadsAreSleeping[i] = true;
                    }
                }
            }

        });
        daemon.setDaemon(true);
        daemon.start();

        while (true) {
            try {
                Thread.sleep(10);
                for (int i = 0; i < 5; i++) {
                    if (threadsAreSleeping[i]){
                        threads[i].interrupt();
                        threadsAreSleeping[i] = false;
                    }
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }




    }
}
