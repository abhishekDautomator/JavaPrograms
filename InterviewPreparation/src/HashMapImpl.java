import java.util.LinkedList;
import java.util.Objects;

public class HashMapImpl {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Abhishek");
        hashMap.put(2, "Anu");
        hashMap.put(7, "Dhriti");
        for(HashMap.Bucket<Integer, String> bucket: hashMap.buckets){
            for (HashMap.Bucket.Entry<Integer, String> entry:bucket.entries){
                System.out.println(entry.key+"-"+entry.value);
            }
        }
    }
    static class HashMap<K, V> {
        int default_capacity = 16;

        Bucket<K, V>[] buckets;

        @SuppressWarnings("unchecked")
        HashMap() {
            buckets = (Bucket<K, V>[]) new Bucket[default_capacity];
            for (int i = 0; i < default_capacity; i++) {
                buckets[i] = new Bucket<>();
            }
        }

        public int getBucketIndex(K key) {
            return key == null ? 0 : Math.abs(key.hashCode()) % default_capacity;
        }

        public void put(K key, V value) {
            int index = getBucketIndex(key);
            Bucket<K, V> bucket = buckets[index];
            bucket.pushOrUpdate(key, value);
        }

        public V getValue(K key) {
            int index = getBucketIndex(key);
            Bucket<K, V> bucket = buckets[index];
            return bucket.getValue(key);
        }

        public boolean containsKey(K key) {
            return getValue(key) != null;
        }

        public int size() {
            int count = 0;
            for (Bucket<K, V> bucket : buckets) {
                count += bucket.entries.size();
            }
            return count;
        }

        public static class Bucket<K, V> {
            LinkedList<Entry<K, V>> entries = new LinkedList<>();

            public void pushOrUpdate(K key, V value) {
                for (Entry<K, V> entry : entries) {
                    if (Objects.equals(entry.key, key)) {
                        entry.value = value;
                        return;
                    }
                }
                entries.add(new Entry<>(key, value));
            }

            public V getValue(K key) {
                for (Entry<K, V> entry : entries) {
                    if (Objects.equals(entry.key, key))
                        return entry.value;
                }
                return null;
            }

            public void remove(K key) {
                entries.removeIf(entry -> Objects.equals(entry.key, key));
            }

            public static class Entry<K, V> {
                K key;
                V value;

                Entry(K key, V value) {
                    this.key = key;
                    this.value = value;
                }
            }
        }
    }
}
