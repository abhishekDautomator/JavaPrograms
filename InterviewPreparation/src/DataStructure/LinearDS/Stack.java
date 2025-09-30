package DataStructure.LinearDS;

public class Stack {
    private final int maxSize;
    private final int[] stackArray;
    private final int[] minArray;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.stackArray = new int[size];
        this.minArray = new int[size];
        this.top = -1;
    }

    public void push(int value){
        if(size()>=maxSize) throw new StackOverflowError("stack is full");
        int increment = ++top;
        stackArray[increment] = value;
        if (top == 0) {
            minArray[increment] = value; // first element
        } else {
            minArray[increment] = Math.min(value, minArray[top - 1]);
        }

    }

    public boolean isEmpty(){
        return top==-1;
    }

    public int pop(){
        if(isEmpty()) throw new IllegalStateException("stack is empty");
        return stackArray[top--];
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("stack is empty");
        return stackArray[top];
    }

    public int size(){
        return top+1;
    }

    public int getMin(){
        return minArray[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of size 5
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Minimum value is "+stack.getMin());
        System.out.println("Top element: " + stack.peek()); // Output: Top element: 30
        System.out.println("Stack size: " + stack.size());  // Output: Stack size: 3
        System.out.println("Popped element: " + stack.pop()); // Output: Popped element: 30
        System.out.println("New top element: " + stack.peek()); // Output: New top element: 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? false
        stack.pop(); // Remove 20
        stack.pop(); // Remove 10
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? true
    }
}
