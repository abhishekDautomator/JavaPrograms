package Java8;

import java.util.Arrays;
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

        //To extract unique company names from a List<People> using Java Streams, you can flatten the list of companies from each person, then collect them into a Set to ensure uniqueness, and finally convert it to a List if needed.
        //Here’s a clean and idiomatic way to do it:
        record People(String name, List<String> companies){}
        List<People> peopleList = Arrays.asList(
                new People("Abhishek", Arrays.asList("Cognizant", "Ajio")),
        new People("Anu", Arrays.asList("IBM", "Accenture")),
        new People("Abha", Arrays.asList("Capgemini", "Accenture"))
        );

        List<String> uniqueCompanies = peopleList.stream()
            .flatMap(person -> person.companies().stream()) // flatten all company lists
           .distinct()                                     // remove duplicates
            .toList();                  // collect as List

        System.out.println("UniqueCompanies: "+uniqueCompanies);
        //
        //
        //✅ Alternative using Set for uniqueness:
        //If you prefer to collect directly into a Set (e.g., LinkedHashSet to preserve order):
        //Set<String> uniqueCompanies = peopleList.stream()
        //    .flatMap(person -> person.companies().stream())
        //    .collect(Collectors.toCollection(LinkedHashSet::new));
        //
        //
        //🧠 Breakdown:
        //- flatMap(...): merges all List<String> from each People record into one stream.
        //- distinct(): ensures uniqueness (optional if collecting into a Set).
        //- collect(...): gathers the results into a desired collection.
        //Let me know if you want to group companies by age, count frequency, or sort them alphabetically — we can layer more logic easily.
    }
}