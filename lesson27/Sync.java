package TRJavaHWs.lesson27;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;

public class Sync {
    public static void main(String[] args) throws InterruptedException {
        Incrementer inc = new Incrementer();


        for (int i = 0; i < 4; i++) {
            (new Thread(() -> {
                synchronized (inc) {
                    for (int j = 0; j < 1000; j++) {
                        Modifier.setX(Producer.produce());
                        Modifier.setFunc(FunctionProducer.produce());
                        inc.increment(Modifier.Modify());
//                        Modifier.setX(10);                // для теста
//                        Modifier.setFunc((x->x*10));      // для теста
//                        inc.increment(Modifier.Modify()); // для теста
                    }
                }

            })).start();
        }

        Thread.sleep(1000);
        System.out.println(inc.getCount());
    }


}

class Incrementer {
    private int count;
//    private volatile AtomicInteger count = new AtomicInteger(0);

    public void increment(int x) {
//        count.incrementAndGet();
        count += x;
    }

    public int getCount() {
        return count;
    }

}

class Modifier {
    private static int x;
    private static IntFunction<Integer> func;
    public static int Modify(){
        return func.apply(x);
    }

    public static void setX(int a){
        x = a;
    }

    public static void setFunc(IntFunction<Integer> func) {
        Modifier.func = func;
    }
}

class FunctionProducer {
    private static List<IntFunction<Integer>> list = new ArrayList<>();

    static {
        list.add(x->x+2);
        list.add(x->x*(-1));
        list.add(x->x+3);
    }
    private static Random r = new Random();

    public static IntFunction<Integer> produce() {
        return list.get(r.nextInt(0,3));
    }
}

class Producer {
    private static Random r = new Random();

    public static int produce(){
        return r.nextInt(10);
    }
}
