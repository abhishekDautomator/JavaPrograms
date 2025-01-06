import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTraverseVariousWays {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // 1. Using a For Loop
        System.out.println("Using For Loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 2. Using Enhanced For Loop
        System.out.println("\nUsing Enhanced For Loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // 3. Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // 4. Using ListIterator
        System.out.println("\nUsing ListIterator:");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String fruit = listIterator.next();
            System.out.println(fruit);
        }

        // 5. Using Stream API
        System.out.println("\nUsing Stream API:");
        list.stream().forEach(System.out::println);

        // 6. Using forEach() Method
        System.out.println("\nUsing forEach() Method:");
        list.forEach(fruit -> System.out.println(fruit));
    }
}
