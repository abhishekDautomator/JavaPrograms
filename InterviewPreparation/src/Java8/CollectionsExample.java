package Java8;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionsExample {
    //Java 8 added simplified immutable collection initialization methods, such as `List.of` and `Map.of`
    public static void main(String[] args) {
        List<String> namesList = List.of("Plice", "Bob", "Charlie");
        Map<String, Integer> ages = Map.of("Alice", 25, "Bob", 30);

        System.out.println("Names: " + namesList);
        System.out.println("Ages: " + ages);

        // Explanation:
        // 1. `List.of` creates an immutable list with given elements.
        // 2. `Map.of` creates an immutable map with key-value pairs.
        
        // Stream example: filter and map operations
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("A")) // Only names starting with 'A'
                                          .map(String::toUpperCase) // Convert to uppercase
                                          .toList(); // Collect to list
        System.out.println("Filtered Names: " + filteredNames);

        // Optional example: Safe access on collections
        Optional<String> firstMatchingName = names.stream()
                                                  .filter(name -> name.length() > 3) // Finds name longer than 3 characters
                                                  .findFirst();
        firstMatchingName.ifPresent(name -> System.out.println("First Matching Name: " + name)); // Print if present

        // Collectors.joining example: Joining elements in a single string
        String joinedNames = names.stream().collect(Collectors.joining(", ", "[", "]")); // Join with prefix/suffix
        System.out.println("Joined Names: " + joinedNames);
        
        // flatMap example: Flatten nested lists
        List<List<Integer>> nestedLists = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        List<Integer> flattenedList = nestedLists.stream()
                                                 .flatMap(List::stream) // Flatten nested lists
                                                 .toList(); // Collect to a single list
        System.out.println("Flattened List: " + flattenedList);
    }
}