package Java8.collection;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapLambda {
    public static void main(String[] args) {
        Map<Integer, String> m= new TreeMap<>((a,b)->a>b?-1:a<b?1:0);
        m.put(0,"Abhishek");
        m.put(25,"Narayan");
        m.put(19,"Bittu");
        m.put(56,"Anu");
        System.out.println(m);
    }
}
