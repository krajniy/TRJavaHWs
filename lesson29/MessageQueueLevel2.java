package TRJavaHWs.lesson29;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageQueueLevel2 {
    private String message;
    private int maxSize;
    private Deque<String> messages;

    public MessageQueueLevel2(int maxSize) {
        this.maxSize = maxSize;
        this.messages = new ArrayDeque<>();
    }

    public synchronized void send(String message) throws InterruptedException {
        while (messages.size() == maxSize) {
            wait();
        }
        messages.push(message);
        notifyAll();
    }

    public synchronized String receive() throws IllegalStateException {
        while (messages.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String msg = messages.pop();
        notifyAll();
        return msg;
    }
}

class Runner2 {
    public static void main(String[] args) {
        MessageQueueLevel2 messageQueue = new MessageQueueLevel2(3);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

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
