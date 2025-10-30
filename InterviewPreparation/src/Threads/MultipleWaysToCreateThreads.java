package Threads;

import java.util.concurrent.*;

public class MultipleWaysToCreateThreads {
    public static void main(String[] args) {
        ByExtendingThreadClass thread1 = new ByExtendingThreadClass();
        thread1.start(); // Start the thread

        Thread thread2 = new Thread(new ImplementingRunnableInterface());
        thread2.start();

        LambdaExpression  thread3 = new LambdaExpression();
        thread3.thread.start();

        UsingExecutorService thread4 = new UsingExecutorService();
        thread4.executor.submit(() -> {
            System.out.println("Thread using Executor is running");
        });
        thread4.executor.shutdown();  // Initiates an orderly shutdown

        UsingCallableAndFuture thread5 = new UsingCallableAndFuture();
        Callable<String> task = () -> "Running thread using Callable and Future";
        Future<String> future = thread5.executor.submit(task);
        try{
            System.out.println(future.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            thread5.executor.shutdown();  // Initiates an orderly shutdown
        }

        //Using Anonymous class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread using anonymous class");
            }
        };

        Thread thread6 = new Thread(runnable);
        thread6.start();
    }
}

class ByExtendingThreadClass extends Thread {
    //You can create a new thread by extending the Thread class and overriding its run() method.
    @Override
    public void run() {
        System.out.println("Thread is running by extending Thread class");
    }
}

class ImplementingRunnableInterface implements Runnable {
    //Another common way to create a thread is by implementing the Runnable interface. This approach is
    // preferred when your class already extends another class because Java does not support multiple
    // inheritance.
    @Override
    public void run() {
        System.out.println("Thread is running by implementing Runnable interface");
    }
}

class LambdaExpression{
    //If you are using Java 8 or later, you can simplify the implementation of the Runnable
    // interface using lambda expressions.
    Thread thread = new Thread(() -> {
        System.out.println("Thread is running using lambda expression");
    });
}

class UsingExecutorService{
    //The ExecutorService framework provides a higher-level abstraction for managing threads.
    // It manages a pool of threads and simplifies thread management, allowing for better
    // resource utilization.
    ExecutorService executor = Executors.newFixedThreadPool(2);
}

class UsingCallableAndFuture{
    //For tasks that return a result, you can use the Callable interface along with
    // ExecutorService, which allows tasks to return results and handle exceptions more
    // effectively.
    ExecutorService executor = Executors.newCachedThreadPool();
}


