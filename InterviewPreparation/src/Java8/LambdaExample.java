package Java8;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    //Lambda expressions in Java 8 were introduced to simplify
    // the way to represent functional interfaces.
    // They allow defining methods in a concise and readable manner.
    // Lambda expressions also enhance the Collection libraries,
    // making it easier to iterate, filter, and extract data from a collection.

    public static void main(String[] args) {
        // Define a list of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using a lambda expression to iterate through the list and print each name
        names.forEach(name -> System.out.println("Hello, " + name));

        // Explanation:
        // `names.forEach` accepts a lambda function. The lambda `name -> System.out.println("Hello, " + name)` takes each name from the list.
        // It processes (prints) each name by prefixing it with "Hello".
    }
}