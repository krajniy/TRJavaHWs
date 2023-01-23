package TRJavaHWs.lesson28.hw;

public class PromiseDemo {
    public static void main(String[] args) {

        Promise<Integer> p = (new PromiseRunner()).run(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        while (!p.hasValue()){
            System.out.println("Waiting");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(p.getValue());
    }
}
