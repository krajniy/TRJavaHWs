package TRJavaHWs.lesson28;


public class BasicSemaphore {
    private final TestSubject t = new TestSubject();
    private int availableResources = 1;
    private final Object lock = new Object();

    public TestSubject acquire() {
        synchronized (lock) {
            while (availableResources == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            availableResources--;
            return t;
        }
    }

    public void release() {
        synchronized (lock) {
            availableResources++;
            lock.notify();
        }


    }


}

class TestSubject {
    private int count = 0;

    public void test() {
        System.out.println("Called " + ++count);
    }
}

class Runner {
    public static void main(String[] args) {
        BasicSemaphore s = new BasicSemaphore();
        for (int i = 0; i < 10; i++) {

            (new Thread(() -> {
                TestSubject t = s.acquire();
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    t.test();
                }
                s.release();
            })).start();
        }


    }
}