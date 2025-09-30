package PubSub;

public class ClassicPubSub {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread pubThread = new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    buffer.publish(i);
                    Thread.sleep(1000); //simulate delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread subThread = new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    buffer.subscribe();
                    Thread.sleep(1000); //simulate delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

            }
        });

        pubThread.start();
        subThread.start();
    }
}
