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
    // entries are stored in a linked list (or a balanced tree if the number of entries in
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
}
