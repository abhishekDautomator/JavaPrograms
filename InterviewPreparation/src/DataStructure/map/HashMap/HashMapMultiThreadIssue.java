package DataStructure.map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapMultiThreadIssue {
    public static void main(String[] args) {
        //In the above code, if both threads execute concurrently, it may lead to unexpected
        // results or exceptions because DataStructure.map.HashMap is not thread-safe.

        Map<Integer, String> map = new HashMap<>(); //Use ConcurrentHashMap if multiple threads are there

        // Thread 1
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Value " + i);
            }
        }).start();

        // Thread 2
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(map.get(i));
            }
        }).start();
    }
}
