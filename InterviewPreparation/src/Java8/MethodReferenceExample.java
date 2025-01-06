package Java8;

import java.util.Arrays;

public class MethodReferenceExample {
    //Method references are shorthand for lambda expressions when a specific method already exists for reuse. It improves code readability.
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Orange", "Banana"};

        Arrays.sort(fruits, String::compareToIgnoreCase);

        Arrays.asList(fruits).forEach(System.out::println);

        // Explanation:
        // 1. `String::compareToIgnoreCase` is a method reference that compares strings.
        // 2. `System.out::println` is a method reference for printing objects to the console.
    }
}