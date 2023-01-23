package TRJavaHWs.lesson29;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestDeadlock {
    public static void main(String[] args) {
        final String resource1 = "Dead";
        final String resource2 = "Lock";

        // t1 tries to lock resource1 then resource2
        (new Thread(() -> {
            boolean lock1 = false;
            boolean lock2 = false;
            try {
                lock1 = tryLock(resource1);
                if (lock1) {
                    System.out.println("Thread 1: locked resource 1");

                    Thread.sleep(100);

                    lock2 = tryLock(resource2);
                    if (lock2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            } catch (InterruptedException ignored) {
            } finally {
                if (lock1) {
                    unlock(resource1);
                }
                if (lock2) {
                    unlock(resource2);
                }
                System.out.println("Thread 1: all locks exited");
            }
        })).start();

        // t2 tries to lock resource2 then resource1
        (new Thread(() -> {
            boolean lock1 = false;
            boolean lock2 = false;
            try {
                lock1 = tryLock(resource2);
                if (lock1) {
                    System.out.println("Thread 2: locked resource 2");

                    Thread.sleep(100);

                    lock2 = tryLock(resource1);
                    if (lock2) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            } catch (InterruptedException ignored) {
            } finally {
                if (lock1) {
                    unlock(resource2);
                }
                if (lock2) {
                    unlock(resource1);
                }
                System.out.println("Thread 2: all locks exited");
            }
        })).start();
    }

    private static final Map<String, java.util.concurrent.locks.Lock> locks = new HashMap<>();

    private static boolean tryLock(String resource) throws InterruptedException {
        java.util.concurrent.locks.Lock lock = locks.computeIfAbsent(resource, k -> new java.util.concurrent.locks.ReentrantLock());
        return lock.tryLock(10, TimeUnit.SECONDS);
    }

    private static void unlock(String resource) {
        java.util.concurrent.locks.Lock lock = locks.get(resource);
        if (lock != null) {
            lock.unlock();
        }
    }
}
