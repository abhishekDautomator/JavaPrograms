package Java8;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    //Parallel Streams were introduced in Java 8 to **leverage multi-core CPUs** for better
    // performance. By using `.parallelStream()`, the Stream API splits tasks into smaller chunks
    // and processes them in parallel threads.
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Sequential Stream
        System.out.println("Sequential Stream:");
        names.forEach(System.out::print);

        // Parallel Stream
        System.out.println("\nParallel Stream:");
        names.parallelStream().forEach(System.out::print);

        // Explanation:
        // 1. `stream()` processes items sequentially (one-by-one).
        // 2. `parallelStream()` splits the workload into multiple threads and processes concurrently.
        // 3. The output order for parallel streams may not be guaranteed to be sequential.
    }
}