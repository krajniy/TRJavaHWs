package TRJavaHWs.lesson26.hw;

public class Level1 {
    //TODO:
    // Создать 2 потока
    // 1 Спит 10 секунд, обрабатывает InterruptedException следующим образом:
    // Посчитать, сколько осталось до окончания сна через System.nanoTime()
    // Написать в консоль, сколько еще осталось спать, продлолжить спать оставшееся время
    // 2 Каждые 10 мс проверяет, спит ли поток 1 через Thread.getState()
    // Если поток спит, разбудить его
    // Если поток закончил выполнение, сделать return

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            long start = System.nanoTime();
                sleepThread(10_000, start);

        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                switch (t1.getState()) {
                    case TIMED_WAITING -> t1.interrupt();
                    case TERMINATED -> {
                        return;
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t2.start();

    }

    private static void sleepThread(long ms, long start) {

        if (ms > 0) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                long leftToSleep = (start + 10_000 * 1000000 - System.nanoTime()) / 1000000;
                System.out.println("Left to sleep: " + leftToSleep);
                sleepThread(leftToSleep, start);
            }
        }
    }
}
