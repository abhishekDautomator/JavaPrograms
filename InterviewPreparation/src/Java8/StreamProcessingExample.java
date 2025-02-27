package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamProcessingExample {
    //The Streams API was introduced in Java 8 to simplify working with data stored in collections or arrays.
    // It provides efficient, declarative, and readable methods for performing operations such as filtering,
    // mapping, and reducing.
    public static <Optional> void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Filter even numbers using the Streams API
        List<Integer> evenNumbers = numbers.stream()     // Convert the list to a stream
                .filter(n -> n % 2 == 0)                 // Use lambda to filter only even numbers
                .toList();          // Collect the filtered result into a list

        // Print the processed result
        System.out.println("Even Numbers: " + evenNumbers);

        // Explanation:
        // 1. The `stream()` method creates a Stream from the collection.
        // 2. `.filter()` applies the lambda condition (n % 2 == 0) to keep only numbers divisible by 2.
        // 3. The `collect()` method gathers all elements into a List using `Collectors.toList`.

        // The map() method transforms each element of the stream using a provided function.
        // It returns a new stream consisting of the results of applying the function to each element.
                List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
                List<Integer> nameLengths = names.stream()
                        .map(String::length)
                        .toList();
        // nameLengths will contain [5, 3, 7]
        System.out.println("length of each names in the list is: "+nameLengths);

        // The flatMap() method is used to flatten a stream of collections into a single stream.
        // It applies a function that returns a stream for each element and concatenates the resulting streams.
                List<List<String>> listOfLists = Arrays.asList(
                        Arrays.asList("A", "B"),
                        Arrays.asList("C", "D")
                );
                List<String> flattenedList = listOfLists.stream()
                        .flatMap(Collection::stream)
                        .toList();
        // flattenedList will contain ["A", "B", "C", "D"]

        // The distinct() method returns a stream consisting of distinct elements (removes duplicates).
        List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers1.stream()
                .distinct()
                .toList();
        // distinctNumbers will contain [1, 2, 3, 4, 5]

        // The sorted() method sorts the elements of the stream in natural order or by a provided comparator.
        List<String> names1 = Arrays.asList("Charlie", "Alice", "Bob");
        List<String> sortedNames = names1.stream()
                .sorted()
                .toList();
        // sortedNames will contain ["Alice", "Bob", "Charlie"]

        // The limit() method returns a stream consisting of the elements of the original stream,
        // truncated to be no longer than a given size.
                List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
                List<Integer> limitedNumbers = numbers2.stream()
                        .limit(3)
                        .toList();
        // limitedNumbers will contain [1, 2, 3]

        // The skip() method returns a stream consisting of the remaining elements after discarding
        // the first n elements from the original stream.
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> skippedNumbers = numbers3.stream()
                .skip(2)
                .toList();
        // skippedNumbers will contain [3, 4, 5]

        // The reduce() method performs a reduction on the elements of the stream using an
        // associative accumulation function.
        // It can be used to combine elements into a single result.
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4);
        java.util.Optional<Integer> sum = numbers4.stream()
                .reduce(Integer::sum);
        // sum will be Optional[10]

        // The collect() method is a terminal operation that transforms the elements of the stream
        // into a different form, usually a collection such as a List, Set, or Map.
        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie");
        Set<String> nameSet = names2.stream()
                .collect(Collectors.toSet());
        // nameSet will contain {"Alice", "Bob", "Charlie"}

        // The forEach() method is a terminal operation that performs an action for each element
        // of the stream. It is often used for side effects.
        List<String> names3 = Arrays.asList("Alice", "Bob", "Charlie");
        names3.stream()
                .forEach(System.out::println);
        // Outputs: Alice, Bob, Charlie

        // The anyMatch() method checks if any elements of the stream match the provided predicate.
        // It returns true if at least one element matches, otherwise false.
        List<String> names4 = Arrays.asList("Alice", "Bob", "Charlie");
        boolean hasA = names4.stream()
                .anyMatch(name -> name.startsWith("A"));
        // hasA will be true


        // The allMatch() method checks if all elements of the stream match the provided predicate.
// It returns true only if all elements match, otherwise false.
        List<String> names5 = Arrays.asList("Alice", "Bob", "Charlie");
        boolean allStartWithA = names5.stream()
                .allMatch(name -> name.startsWith("A"));
// allStartWithA will be false


        // The noneMatch() method checks if no elements of the stream match the provided predicate.
// It returns true if no elements match, otherwise false.
        List<String> names6 = Arrays.asList("Alice", "Bob", "Charlie");
        boolean noneStartWithZ = names6.stream()
                .noneMatch(name -> name.startsWith("Z"));
// noneStartWithZ will be true


        // The findFirst() method returns an Optional describing the first element of the stream,
// or an empty Optional if the stream is empty.
        List<String> names7 = Arrays.asList("Alice", "Bob", "Charlie");
        java.util.Optional<String> firstName = names7.stream()
                .findFirst();
// firstName will be Optional["Alice"]

        // The findAny() method returns an Optional describing some element of the stream,
// or an empty Optional if the stream is empty. It may return any element in parallel streams.
        List<String> names8 = Arrays.asList("Alice", "Bob", "Charlie");
        java.util.Optional<String> anyName = names8.stream()
                .findAny();
// anyName could be Optional["Alice"], ["Bob"], or ["Charlie"]

        // The count() method returns the count of elements in the stream as a long value.
        List<String> names9 = Arrays.asList("Alice", "Bob", "Charlie");
        long count = names9.stream()
                .count();
// count will be 3

        // The max() method returns an Optional describing the maximum element of the stream
// according to the provided comparator, or an empty Optional if the stream is empty.
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        java.util.Optional<Integer> maxNumber = numbers5.stream()
                .max(Integer::compareTo);
// maxNumber will be Optional[5]

        // The min() method returns an Optional describing the minimum element of the stream
// according to the provided comparator, or an empty Optional if the stream is empty.
        List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5);
        java.util.Optional<Integer> minNumber = numbers6.stream()
                .min(Integer::compareTo);
// minNumber will be Optional[1]

        // The toArray() method is used to convert the stream into an array.
// It can return an array of a specific type if specified.
        List<String> names10 = Arrays.asList("Alice", "Bob", "Charlie");
        String[] namesArray = names10.toArray(String[]::new);
// namesArray will contain ["Alice", "Bob", "Charlie"]

        // The peek() method is an intermediate operation that allows you to perform an action
// on each element of the stream without modifying it. It's often used for debugging purposes.
        List<String> names11 = Arrays.asList("Alice", "Bob", "Charlie");
        names11.stream()
                .peek(name -> System.out.println("Processing: " + name));
// Outputs: Processing: Alice, Processing: Bob, Processing: Charlie

        // Accumulate names into a List
        // List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

        // Accumulate names into a TreeSet
        // Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

        // Convert elements to strings and concatenate them, separated by commas
        // String joined = things.stream()   .map(Object::toString)   .collect(Collectors.joining(", "));

        // Compute sum of salaries of employee
        // int total = employees.stream()   .collect(Collectors.summingInt(Employee::getSalary));

        // Group employees by department
        // Map<Department,List<Employee>> byDept = employees.stream()   .collect(Collectors.groupingBy(Employee::getDepartment));

        // Compute sum of salaries by department
        // Map<Department,Integer> totalByDept = employees.stream()   .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getSalary)));

        // Partition students into passing and failing
        // Map<Boolean,List<Student>> passingFailing = students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
    }
}