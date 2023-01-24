package TRJavaHWs.lesson29;


public class MessageQueue {
    private String message;

    public synchronized void send(String message) throws InterruptedException {
        while (this.message != null) {
            wait();
        }
        this.message = message;
        notifyAll();
    }

    public synchronized String receive() throws IllegalStateException {
        while (this.message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String msg = this.message;
        this.message = null;
        notifyAll();
        return msg;
    }
}

class Runner {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        for (int i = 0; i < 5; i++) {

            int finalI = i;
            (new Thread(() -> {

                try {
                    messageQueue.send("Hi " + finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            })).start();



            (new Thread(() -> {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(messageQueue.receive());

            })).start();
        }
    }
}