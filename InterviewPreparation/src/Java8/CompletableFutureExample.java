package Java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    //Java 8 added several enhancements to the `java.util.concurrent` utilities, such as `CompletableFuture`.
    //`CompletableFuture` allows writing complex asynchronous code in a readable and maintainable way
    public static void main(String[] args) {
        // Create a CompletableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate some long-running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result from asynchronous task";
        });

        // Process the result (and block until it completes)
        future.thenAccept(result -> System.out.println("Computed Result: " + result)).join();

        // Explanation:
        // 1. `supplyAsync` executes a task asynchronously in a new thread.
        // 2. `thenAccept` processes the result once the task is finished.
        // 3. Calling `join()` waits for the CompletableFuture to complete.
    }
}