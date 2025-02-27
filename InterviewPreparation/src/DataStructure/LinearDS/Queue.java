package DataStructure.LinearDS;

public class Queue {
    private final int maxSize;
    private final int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0; // Front points to the first element
        this.rear = -1; // Rear starts before the first element
        this.currentSize = 0; // Initially, the queue is empty
    }

    public void enqueue(int value){
        if(currentSize==maxSize) throw new IllegalStateException("Queue is full");
        rear = (rear+1)%maxSize;
        queueArray[rear] = value;
        currentSize++;
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");
        int value = queueArray[front];
        front = (front+1)%maxSize;
        currentSize--;
        return value;
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");
        return queueArray[front];
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    public int size(){
        return currentSize;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5); // Create a queue of size 5
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element: " + queue.peek()); // Output: Front element: 10
        System.out.println("Queue size: " + queue.size());    // Output: Queue size: 3
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: Dequeued element: 10
        System.out.println("New front element: " + queue.peek()); // Output: New front element: 20
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false
        queue.dequeue(); // Remove 20
        queue.dequeue(); // Remove 30
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? true
    }
}
