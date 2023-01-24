package TRJavaHWs.lesson29;


public class TestDeadlock2 {
    public static void main(String[] args) {
        final String resource1 = "Dead";
        final String resource2 = "Lock";
        // t1 tries to lock resource1 then resource2
        (new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");

                try {
                    resource1.wait();
                } catch (InterruptedException ignored) {
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
            System.out.println("Thread 1: all locks exited");
        })).start();

        // t2 tries to lock resource2 then resource1
        (new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");

                try {
                    resource2.wait();
                } catch (InterruptedException ignored) {
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
            System.out.println("Thread 2: all locks exited");
        })).start();

        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {
            }

            synchronized (resource1) {
                resource1.notify();
            }
            synchronized (resource2) {
                resource2.notify();
            }
        }).start();

    }
}


