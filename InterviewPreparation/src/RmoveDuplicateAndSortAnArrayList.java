import java.util.*;

public class RmoveDuplicateAndSortAnArrayList {
    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(1, 3, 2, 4, 3, 2, 1);
        //1st way
        Set<Integer> setNum = new LinkedHashSet<>(al);
        System.out.println(setNum.stream().sorted(Comparator.reverseOrder()).toList());

        //2nd way
        System.out.println(al.stream().distinct().sorted(Comparator.reverseOrder()).toList());
    }
}
