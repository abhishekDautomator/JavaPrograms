package Java8;

interface GreeterInterface {

    default void sayHello() {
        System.out.println("Hello from Default Method!");
    }

    static void sayGoodbye() {
        System.out.println("Goodbye from Static Method!");
    }
}

public class DefaultMethodsExample implements GreeterInterface {
    //Default methods enable interfaces to have implementation without breaking existing implementations. Static methods, on the other hand, are utility methods that can be called directly on the interface.

    public static void main(String[] args) {
        DefaultMethodsExample example = new DefaultMethodsExample();

        // Call the default method
        example.sayHello();

        // Call the static method
        GreeterInterface.sayGoodbye();

        // Explanation:
        // 1. The `sayHello` method is a default method that can be overridden by implementing classes.
        // 2. The `sayGoodbye` method, being static, cannot be overridden and is accessed directly from the interface.
    }
}