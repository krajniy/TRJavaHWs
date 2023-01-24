package TRJavaHWs.lesson29;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageQueueLevel3 {
    private String message;
    private int maxSize;
    private int maxReads;
    private Deque<Message> messages;

    public MessageQueueLevel3(int maxSize, int maxReads) {
        this.maxSize = maxSize;
        this.maxReads = maxReads;
        this.messages = new ArrayDeque<>();
    }

    public synchronized void send(String message) throws InterruptedException {
        while (messages.size() == maxSize) {
            wait();
        }
        messages.push(new Message(message, maxReads));
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
        Message msg = messages.peek();
        if (msg.readMessage()) {
            messages.pop();
        }
            notifyAll();
        return msg.getMessage();
    }

    private class Message {
        private String message;
        private int remainingReads;

        public Message(String message, int remainingReads) {
            this.message = message;
            this.remainingReads = remainingReads;
        }

        public String getMessage() {
            return message;
        }

        public boolean readMessage() {
            remainingReads--;
            return remainingReads <= 0;
        }
    }
}

class Runner3 {
    public static void main(String[] args) {
        MessageQueueLevel3 messageQueue = new MessageQueueLevel3(1, 2);
        for (int i = 0; i < 10; i++) {
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
                System.out.println(messageQueue.receive());



            })).start();
        }
    }
}

