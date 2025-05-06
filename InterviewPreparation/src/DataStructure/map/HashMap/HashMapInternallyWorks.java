package DataStructure.map.HashMap;

import java.util.HashMap;

public class HashMapInternallyWorks {
    //A DataStructure.map.HashMap in Java is a part of the Java Collections Framework and is used to store
    // key-value pairs. It allows for efficient retrieval, insertion, and deletion of entries
    // based on keys. The internal workings of a DataStructure.map.HashMap rely on several key concepts:
    // hashing, buckets, and load factor.
    //Default capacity is 16 and the threshold is 12
    //https://www.youtube.com/watch?v=sw-j_ETGBEo&list=PL0zysOflRCen9SPmMO2XN1I2S9m96G_dx&index=3
    //null key entries are added at 0th index.

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Math", 90);
        hm.put("Physics", 80);
        System.out.println(hm);
    }

    //Internal Structure
    //Buckets: A DataStructure.map.HashMap uses an array of buckets (or linked lists) to store the entries.
    // Each bucket corresponds to a hash code calculated from the key.
    //
    //Hash Function: When you insert a key-value pair, the DataStructure.map.HashMap computes the hash code
    // of the key and determines which bucket it should go into by taking the modulus with
    // the array length.
    //
    //Collision Handling: If multiple keys hash to the same bucket (collision), the
    // entries are stored in a linked list (or a balanced tree(RED-BLACK tree) if the number of entries in
    // a bucket exceeds a certain threshold).
    //
    //Load Factor: This indicates how full the DataStructure.map.HashMap can get before it needs to resize.
    // The default load factor is 0.75, meaning that when the map is 75% full, it will be
    // resized (doubled in size).
    //
    //Basic Operations
    //Insertion: When inserting a key-value pair, the put method calculates the hash code,
    // finds the appropriate bucket, and then either adds the new entry or updates the
    // existing entry if the key already exists.
    //
    //Retrieval: The get method retrieves the value associated with a key by computing its
    // hash code and locating the corresponding bucket.
    //
    //Deletion: The remove method also uses the hash code to find the bucket and then
    // removes the entry.

    //how the key values are stored in each bucket?
    // Each bucket in a HashMap is an array of linked lists or trees that store the key-value pairs.
    // When a key-value pair is added, the hash code of the key determines the index of the bucket.
    // If there is a collision, the key-value pair is added to the linked list or tree at that bucket.
    // Each bucket in a HashMap is an array of linked lists or trees that store the key-value pairs.
    // When a key-value pair is added, the hash code of the key determines the index of the bucket.
    // If there is a collision, the key-value pair is added to the linked list or tree at that bucket.
    // The following code simulates the internal structure of a HashMap bucket:
   /* class Bucket {
        LinkedList<Entry> entries;

        public Bucket() {
            entries = new LinkedList<>();
        }

        public void add(String key, Integer value) {
            entries.add(new Entry(key, value));
        }

        class Entry {
            String key;
            Integer value;

            Entry(String key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }
    }*/
    //How multiple key values are added in a bucket after collision?
    //How multiple key values are added in a bucket after collision?
    /*public void add(String key, Integer value) {
        int bucketIndex = getBucketIndex(key);
        Bucket bucket = buckets[bucketIndex];
        bucket.add(key, value);
    }

    private int getBucketIndex(String key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % buckets.length;
    }*/

    //Please explain how a linked list bucket can hold multiple key-values pair if the hash code is same?
    //A linked list bucket can hold multiple key-value pairs if the hash code is the same by chaining the entries
    //together in a linked list. When a new key-value pair is added to the bucket and a collision occurs (meaning
    //the hash code for the new key matches an existing key's hash code), the new entry is appended to the
    //linked list of entries in that bucket. This way, all entries that hash to the same index are stored
    //in a sequence, allowing for multiple key-value pairs to coexist in the same bucket.

    //How the keys are stored in bucket(linked list) as a linked list can store values only and we have only
    // hash code which can correspond to multiple key values?
    //A linked list bucket can hold multiple key-value pairs if the hash code is the same by chaining the entries
    //together in a linked list. When a new key-value pair is added to the bucket and a collision occurs (meaning
    //the hash code for the new key matches an existing key's hash code), the new entry is appended to the
    //linked list of entries in that bucket. This way, all entries that hash to the same index are stored
    //in a sequence, allowing for multiple key-value pairs to coexist in the same bucket.

    //But how it would know during retrieval that this value corresponds to this key? As using hash code only a bucket can be understood?
    /*In a HashMap, the retrieval process involves two main steps to ensure the correct value is returned for a given key:

            1. Locate the Bucket (Using Hash Code)
    When you call map.get(key), the HashMap:

    Computes the hash code of the key (key.hashCode()).

    Applies hashing (typically hash(key.hashCode()) to reduce collisions).

    Uses the hash to determine the bucket index (e.g., index = hash & (arrayLength - 1)).

            2. Search Within the Bucket (Using equals())
    Each bucket can contain multiple entries (due to hash collisions). The HashMap then:

    Iterates through the entries (nodes) in the bucket (could be a linked list or tree in Java 8+).

    Compares the key using key.equals() to find an exact match.

    Returns the value associated with the matching key.

    Example Workflow
    java
            Copy
    HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 10);  // Hash("apple") → Bucket 2
map.put("banana", 20); // Hash("banana") → Bucket 5
map.put("apple", 30);  // Replaces old value (10 → 30)

    // Retrieval:
    int val = map.get("apple"); // Steps:
    // 1. Hash("apple") → Bucket 2
// 2. Check all keys in Bucket 2 using equals("apple")
// 3. Returns 30
    Why Both hashCode() and equals() Matter
    hashCode() determines the bucket (fast lookup).

    equals() ensures the exact key match (handles collisions).

    Key Points to Remember
✔ Same hashCode() ≠ Same Key (collisions happen).
            ✔ Different hashCode() → Different Buckets (no need for equals()).
            ✔ Always override hashCode() and equals() for custom keys (to maintain consistency).*/
}
