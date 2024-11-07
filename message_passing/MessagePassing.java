package message_passing;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessagePassing {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Thread input = new Thread(() -> {
            try {
                queue.put("Hello!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread output = new Thread(() -> {
            try {
                String message = queue.take();
                System.out.println("Received: " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        input.start();
        output.start();
    }
}