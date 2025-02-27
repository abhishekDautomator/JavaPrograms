package Synchronization;

record Resource(String name) {
}

public class DeadLockExample {
    private static final Resource resourceA = new Resource("Resource A");
    private static final Resource resourceB = new Resource("Resource B");

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread 1: Holding lock on " + resourceA.name());

                // Simulating some work with resource A
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for lock on " + resourceB.name());
                synchronized (resourceB) {
                    System.out.println("Thread 1: Acquired lock on " + resourceB.name());
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Thread 2: Holding lock on " + resourceB.name());

                // Simulating some work with resource B
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for lock on " + resourceA.name());
                synchronized (resourceA) {
                    System.out.println("Thread 2: Acquired lock on " + resourceA.name());
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
