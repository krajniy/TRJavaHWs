package TRJavaHWs.lesson29;

import static java.lang.Thread.sleep;

public class JoinWaitNotify {
    public static void main(String[] args) {
        Object o = new Object();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            threads[i] = new Thread(()->{
                synchronized (o){


                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Thread " + finalI + " was awaken");
//                    o.notify();
                }

            });
        }





        Thread t2 = new Thread(()->{
            synchronized (o){

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            o.notifyAll();
            }



        });

        for (Thread thread : threads){
            thread.start();
        }
        t2.start();


    }
}

class Person{
    static synchronized void m1(){
        Person.class.notify();

    }

    synchronized void m2() throws InterruptedException {
        this.wait();
    }
}