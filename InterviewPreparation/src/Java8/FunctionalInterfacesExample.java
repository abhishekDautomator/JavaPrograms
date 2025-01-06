package Java8;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfacesExample {

    public static void main(String[] args) {
        // Predicate: Check if a number is even
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true

        // Consumer: Print out a given string
        Consumer<String> printer = message -> System.out.println("Message: " + message);
        printer.accept("Hello, Java 8!");

        // Supplier: Return a default message
        Supplier<String> defaultMessage = () -> "Default Message";
        System.out.println("Supplier provides: " + defaultMessage.get());

        // Explanation:
        // 1. Predicate is used to evaluate conditions (returns `true` for even numbers here).
        // 2. Consumer is used to 'consume' values without returning a result (prints a message here).
        // 3. Supplier produces a result without requiring an input (supplies "Default Message" here).
    }
}