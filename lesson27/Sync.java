package TRJavaHWs.lesson27;

public class Sync {
    public static void main(String[] args) throws InterruptedException {
    Incrementer inc = new Incrementer();
//        inc.increment();
//        inc.increment();
//        inc.increment();
//        inc.increment();
//        inc.increment();
//        inc.increment();
//        inc.increment();

        for (int i = 0; i < 4; i++) {
            (new Thread(() -> {
                synchronized (inc){

                for (int j = 0; j < 1000; j++) {
                    inc.increment();
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
     public void  increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
