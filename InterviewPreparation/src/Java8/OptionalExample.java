package Java8;

import java.util.Optional;

public class OptionalExample {
    //The `Optional` class was introduced in Java 8 to avoid null pointer exceptions and make code more readable when dealing with null values. It provides methods like `ifPresent`, `isPresent`, and `orElse` to handle null values gracefully
    public static void main(String[] args) {
        // Define a nullable string value
        String name = "John";

        // Wrap the string in an Optional object
        Optional<String> optionalName = Optional.of(name);

        // Print the value if it is present
        optionalName.ifPresent(System.out::println);

        // Provide a default value when the original value is null
        String resolvedName = optionalName.orElse("Default Name");

        System.out.println("Resolved Name: " + resolvedName);

        // Explanation:
        // 1. `Optional.ofNullable(name)` wraps the value, allowing it to be null.
        // 2. `ifPresent` is used to perform an action (print) only if the value exists.
        // 3. `orElse("Default Name")` is used to return a default if the value is null.
    }
}