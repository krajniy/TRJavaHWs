package TRJavaHWs.lesson26.hw;

public class ClassImpl {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            long start = System.nanoTime();
            long end = start + 10000 * 1000000L;
            long sleepTime = 10000;
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
        t1.start();
        Thread t2 = new Thread(() -> {
            while (t1.getState() != Thread.State.TERMINATED) {
                try {
                    Thread.sleep(10);
                    if (t1.getState() == Thread.State.TIMED_WAITING) {
                        System.out.println("Thread 1 is sleeping and must be interrupted");
                        t1.interrupt();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
            System.out.println("Thread 1 was terminated");

        });
//        t2.start();

        Thread t3 = new Thread(() -> {
            long start = System.nanoTime();
            long end = start + 10000 * 1000000L;
            long sleepTime = 10000;
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
        t3.start();
    }
}
