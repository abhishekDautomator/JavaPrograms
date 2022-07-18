package Java8.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListLambda {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(4);
        l.add(20);
        l.add(2);
        System.out.println("Before sorting : "+l);
        Collections.sort(l);
        System.out.println("After sorting using default Collections.sort(): "+l);
        Collections.sort(l, (a,b) -> a>b?-1:a<b?1:0);
        System.out.println("After sorting using default MyComparator: "+l);
    }
}
