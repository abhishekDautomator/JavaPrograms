package Java8.predicate;

import java.util.function.IntPredicate;

public class PrimitivePredicate {
    public static void main(String[] args) {
        int[] arr = {2,9,15,4,31,100};
        IntPredicate evenNumber = n -> n%2==0;
        int j = 0;
        for (int i:
             arr) {
            System.out.println("int at index " + j + " is an even number : " + evenNumber.test(i));
            j++;
        }
    }
}
