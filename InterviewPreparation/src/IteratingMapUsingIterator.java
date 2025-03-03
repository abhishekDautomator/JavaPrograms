import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratingMapUsingIterator {
    public static void main(String[] args) {

        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("Apple", 1);
        fruits.put("Banana", 2);
        fruits.put("Cherry", 3);
        fruits.put("Date", 4);

        Iterator<Map.Entry<String, Integer>> iterator = fruits.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            System.out.println("Fruit "+e.getKey()+" quantity is: "+e.getValue());

            if(e.getKey().equals("Cherry")) iterator.remove();
        }

        System.out.println(fruits);
    }
}
