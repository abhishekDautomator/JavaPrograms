package Java8;

import DataStructure.map.HashMap.ConcurrenthashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionsExample <T> {

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor){
        Set<Object> set = ConcurrentHashMap.newKeySet();
        return t-> set.add(keyExtractor.apply(t));
    }

    //Java 8 added simplified immutable collection initialization methods, such as `List.of` and `Map.of`
    public static void main(String[] args) {

        List<CollectorsExample.Person> people = Arrays.asList(
                new CollectorsExample.Person("Abhishek", 32, "Bangalore"),
                new CollectorsExample.Person("Anu", 32, "Bangalore"),
                new CollectorsExample.Person("Dhriti", 2, "Bangalore"),
                new CollectorsExample.Person("Narayan", 30, "Bangalore"),
                new CollectorsExample.Person("Sah", 28, "Bangalore"),
                new CollectorsExample.Person("Abhishek", 32, "Patna"),
                new CollectorsExample.Person("Anu", 32, "Patna"),
                new CollectorsExample.Person("Dhriti", 2, "Patna"),
                new CollectorsExample.Person("Narayan", 30, "Patna"),
                new CollectorsExample.Person("Sah", 28, "Patna")
        );

        //converting list<list<T>> into flat List<T>
        List<List<?>> listOfList = List.of(List.of("Abhishek","Narayan"),List.of("Anu","Sah"));
        System.out.println(listOfList.stream().flatMap(Collection::stream).toList());

        //group a list of objects by a property
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        Map<Integer, List<String>> groupedByLength = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + groupedByLength);

        //sum of even number from an array of integers
        int[] ar= {1,4,2,7,9,5};
        int sum=Arrays.stream(ar)

                .filter(even->even%2==0)
                .reduce(0,Integer::sum);

        System.out.println(sum);

        // sum of odd numbers from a list of integers
        List<Integer> ar1= Arrays.asList(1,4,2,7,9,5);
        int sum1=ar1.stream()

                .filter(odd->odd%2!=0)
                .reduce(0,Integer::sum);

        System.out.println(sum1);
        // remove duplicates from list of int
        List<Integer> listNum= Arrays.asList(1,4,5,9,1,2,7,9,5);
        List <Integer> nonDup=listNum.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .toList();

        System.out.println("non duplicate list: "+nonDup);

        // remove duplicates from a stream based on a custom key
        //we need to create a helper method

        List<CollectorsExample.Person> newList = people.stream()
                .filter(distinctByKey(CollectorsExample.Person::name))
                .toList();
        System.out.println("People list distinct by name: "+newList);

        Map<String, CollectorsExample.Person> newList2 = people.stream()
                .collect(Collectors.toMap(
                        CollectorsExample.Person::name,
                        Function.identity(),
                                (existing, latest) -> existing
                        ));

        List<CollectorsExample.Person> listDistinctPerson = new ArrayList<>(newList2.values());
        System.out.println("People list distinct by name using 2nd way: "+listDistinctPerson);

        //count the number of characters in a character array using stream
        char[] charArr = {'a', 'g', 's','a','r','s'};

        Map<Character, Long> mapChar = IntStream.range(0, charArr.length)
                .mapToObj(i->charArr[i])
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("count of each char in "+ Arrays.toString(charArr) +" is: "+mapChar);

        //finding the max value from a list of integer
        int maxNum = listNum.stream().max(Comparator.naturalOrder()).get(); //option1
        int n = listNum.stream().mapToInt(Integer::intValue).max().getAsInt(); //option2
        int m = Collections.max(listNum); //option3

        System.out.println("Max num in "+listNum+" is "+maxNum);

        //getting top 2 values from a list of numbers after removing duplicate
        //top N elements from a stream based on a comparator
        List<Integer> top2 = listNum.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .toList();

        System.out.println("top 2 values in "+listNum+" is "+top2);

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