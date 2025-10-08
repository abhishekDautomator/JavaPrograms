package Java8.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetLambda {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>((a,b)-> b.compareTo(a));
        set.add(10);
        set.add(4);
        set.add(20);
        set.add(2);
        System.out.println(set.descendingSet());
    }
}
