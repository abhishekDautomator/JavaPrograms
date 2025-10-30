package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExample {
    record Person(String name, int age, String city){ }

    record Employee(String name, String department, String role, long salary){}

    public static void main(String[] args) {
    /**
     * Given List<Person> where Person has getName(), getAge(), getCity(). Produce a
     * LinkedHashMap<String, List<String>> mapping each city to the alphabetically sorted names
     * of the three youngest people in that city
     */
    List<Person> people = Arrays.asList(
            new Person("Abhishek", 32, "Bangalore"),
            new Person("Anu", 32, "Bangalore"),
            new Person("Dhriti", 2, "Bangalore"),
            new Person("Narayan", 30, "Bangalore"),
            new Person("Sah", 28, "Bangalore"),
            new Person("Abhishek", 32, "Patna"),
            new Person("Anu", 32, "Patna"),
            new Person("Dhriti", 2, "Patna"),
            new Person("Narayan", 30, "Patna"),
            new Person("Sah", 28, "Patna")
    );


    HashMap<String, List<String>> result = people.stream()
            .collect(
                    Collectors.groupingBy(
                            Person::city,
                            LinkedHashMap::new,
                            Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    list -> list.stream()
                                            .sorted(Comparator.comparingInt(Person::age))
                                            .limit(3)
                                            .map(Person::name)
                                            .sorted()
                                            .toList()
                            )
                    )
            );

        System.out.println(result);

        //Given a List<Employee> with getDepartment() and getRole(), how would you group employees
        // first by department and then by role?

        List<Employee> employeeList = Arrays.asList(
                new Employee("Abhishek", "Engineering", "developer", 2700000),
                new Employee("Deepak", "Engineering", "developer", 3000000),
                new Employee("Anupriya", "Engineering", "Tester", 1800000),
                new Employee("Dhriti", "Management", "Manager", 4000000),
                new Employee("Sah", "Management", "Senior Manager", 5000000),
                new Employee("Narayan", "Management", "Manager", 3600000),
                new Employee("priya", "HR", "Recruiter", 1200000)
        );

        Map<String, Map<String, List<Employee>>> grpEmpByDeptOfGrpOfEMpByrle =
                employeeList.stream().collect(Collectors.groupingBy(Employee::department,
                    LinkedHashMap::new,
                    Collectors.groupingBy(Employee::role)
                ));

        System.out.println("Ans 2:- "+grpEmpByDeptOfGrpOfEMpByrle);

        //How would you return a Map<Department, List<Employee>> where each department
        // maps to the top 3 highest-paid employees?
        Map<String, List<Employee>> output = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(
                               Collectors.toList(),
                                e->e.stream()
                                        .sorted(Comparator.comparingLong(Employee::salary).reversed())
                                        .limit(3)
                                        .toList()
                        )));
        System.out.println("Ans 3: "+output);

        //Can you write a custom collector that accumulates strings into a comma-separated format
        // but skips null or empty values?

        List<String> stringList = Arrays.asList("Abhishek", "Anupriya", "Dhriti", "Narayan");

        String commaSeparatedString = stringList.stream()
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.joining(","));


        System.out.println("Ans4: "+commaSeparatedString);

        //How would you flatten a List<List<Order>> into a single List<Order> using streams

        List<List<String>> eatables= List.of(List.of("Apple","Banana"), List.of("Potato","Onion"));
        System.out.println("Ans5: "+eatables.stream().flatMap(List::stream).toList());

        //Java 8 introduced several **collectors** to simplify working with data aggregation and transformation:
        //- **`groupingBy`**: Groups elements by a classifier.
        //- **`partitioningBy`**: Partitions elements into two groups based on a Predicate.

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