package Java8.MapVsFlatMap;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        List<List<String>> namesList = List.of(
                List.of("Alice", "Ava"),
                List.of("Bob"),
                List.of("Charlie", "Chuck")
        );

        // Using flatMap to flatten the list of lists into a single list
        List<String> allNames = namesList.
                stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(allNames); // Output: [Alice, Ava, Bob, Charlie, Chuck]
    }
}
