package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExample {
    //Java 8 introduced several **collectors** to simplify working with data aggregation and transformation:
    //- **`groupingBy`**: Groups elements by a classifier.
    //- **`partitioningBy`**: Partitions elements into two groups based on a Predicate.
    public static void main(String[] args) {
        // List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Grouping by even and odd numbers
        Map<Boolean, List<Integer>> groupedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Grouped Numbers (Odd/Even): " + groupedNumbers);

        // Explanation:
        // 1. partitioningBy divides elements into two groups based on the predicate (even/odd in this case).
        // 2. The result is a Map with keys `true` (even) and `false` (odd).

        // Grouping strings by length
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        Map<Integer, List<String>> groupedByLength = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + groupedByLength);

        // Joining strings with a delimiter
        String joinedStrings = String.join(", ", strings);
        System.out.println("Joined strings: " + joinedStrings);

        // Mapping strings to uppercase
        List<String> uppercaseStrings = strings.stream().map(String::toUpperCase).toList();
        System.out.println("Uppercase strings: " + uppercaseStrings);

        // Counting elements
        long count = strings.size();
        System.out.println("Count of strings: " + count);

        // Reducing to sum of numbers
        int sum = numbers.stream().reduce(0,Integer::sum);
        System.out.println("Sum of numbers: " + sum);
    }
}