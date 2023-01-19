package TRJavaHWs.lesson28;


public class BasicSemaphore {
    private final TestSubject t = new TestSubject();
    private boolean flag = true;

    public  TestSubject acquire() {
        if (flag) {
            flag = !flag;
        return this.t;
        } else {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException();

    }

    public  void release() {
        flag = true;


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


        (new Thread(() -> {


        })).start();
    }
}