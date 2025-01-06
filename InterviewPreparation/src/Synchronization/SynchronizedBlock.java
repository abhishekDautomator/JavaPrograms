package Synchronization;

class SharedResource {
    private int value = 0;

    public void increment() {
        // Synchronized block
        synchronized (this) {
            value++;
        }
    }

    public int getValue() {
        return value;
    }
}

public class SynchronizedBlock {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                resource.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                resource.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Value: " + resource.getValue()); // Should print 2000
    }
}



