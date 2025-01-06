package HashMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrenthashMap {
    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Adding entries
        map.put("Apple", 1);
        map.put("Banana", 2);

        // Concurrent updates
        map.putIfAbsent("Orange", 3); // Adds if not present
        map.replace("Banana", 2, 5);   // Replaces value if current value is 2

        // Retrieving values
        System.out.println("Apple: " + map.get("Apple")); // Output: Apple: 1

        // Iterating over entries
        map.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        // Removing an entry
        map.remove("Apple");
    }
}
