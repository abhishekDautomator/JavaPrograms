package DataStructure.map.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapRemovalWhileIterating {
    public static void main(String[] args) {
        // Create a DataStructure.map.HashMap and populate it
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        // Use an iterator to safely remove mappings while iterating
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());

            // Condition to remove the mapping (for example, remove entries with key 2)
            if (entry.getKey() == 2) {
                iterator.remove(); // Safely remove the current entry
            }
        }

        // Print the map after removal
        System.out.println("Map after removal: " + map);
    }
}
