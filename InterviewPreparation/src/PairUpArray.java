import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PairUpArray {
    public static void main(String[] args) {
        List<List<Integer>>  arrList = new ArrayList<>();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5};
        for(int i:arr1){
            for(int j:arr2){
                arrList.add(List.of(i,j));
            }
        }

        System.out.println(arrList);

        List<List<Integer>> arrList2 = IntStream.of(arr1)
                .boxed() // Convert IntStream to Stream<Integer>
                .flatMap(i -> IntStream.of(arr2)
                        .boxed() // Convert IntStream to Stream<Integer>
                        .map(j -> List.of(i, j))) // Create a pair of i and j
                .collect(Collectors.toList()); // Collect results into a List

        System.out.println(arrList2);
    }


}