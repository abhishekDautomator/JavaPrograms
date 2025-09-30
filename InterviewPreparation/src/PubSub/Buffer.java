package PubSub;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private final Queue<Integer> queue= new LinkedList<>();

    public synchronized void publish(int value) throws InterruptedException {
        int capacity = 5;
        while(queue.size()== capacity){
            wait();
        }
        queue.add(value);
        System.out.println("push event happened");
        notify();
    }

    public synchronized int subscribe() throws InterruptedException {
        while(queue.isEmpty()){
            wait();
        }
        int val = queue.poll();
        System.out.println("subscribe event happened");
        notify();
        return val;
    }
}
