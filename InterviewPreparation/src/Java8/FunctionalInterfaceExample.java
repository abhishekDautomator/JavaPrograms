package Java8;

import java.util.function.Function;

public class FunctionalInterfaceExample {
    //Java 8 introduced functional interfaces that have just a single abstract method.
    // These interfaces can be implemented using lambda expressions, simplifying code.
    //
    // Common examples include `Function`, `Predicate`, and `Consumer`.
    public static void main(String[] args) {
        // Using the Function interface to calculate the length of a string
        Function<String, Integer> lengthFunction = String::length;

        // Apply the Function to get the length of the string "Hello"
        int length = lengthFunction.apply("Hello");

        System.out.println("Length of 'Hello': " + length);

        // Explanation:
        // 1. `Function` is a functional interface that takes a single input and returns a result.
        // 2. The lambda `str -> str.length()` defines how the input string will be processed (its length is calculated).
        // 3. The `apply` method runs this lambda on the input "Hello".
    }
}