package Java8.streams;

import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Integer[] arr = {2,5,6,7,30,25,1,0,9};
        Stream<Integer> s = Stream.of(arr);
        s.forEach(System.out::println);
    }
}
