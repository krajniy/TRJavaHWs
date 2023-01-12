package TRJavaHWs.lesson26.hw;

public class Level2 {
    //TODO:
    // 2. Модифицировать первую часть так, чтобы 2 поток интерраптил первый, даже если он активен
    // Первый поток должен самостоятельно проверять свой флаг isInterrupted и выводить в консоль,
    // что была попытка его разбудить, но он не спал
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            long start = System.nanoTime();
            sleepThread(10_000, start);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                if (!t1.isInterrupted()) {
                    t1.interrupt();

                }
                if (t1.getState().equals(Thread.State.TERMINATED)) {
                    return;
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

        if (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                System.out.println("Interruption attempt");
                long leftToSleep = (start + 10_000 * 1000000 - System.nanoTime()) / 1000000;
                System.out.println("Left to sleep: " + leftToSleep);
                sleepThread(leftToSleep, start);
            }
        }
    }
}
