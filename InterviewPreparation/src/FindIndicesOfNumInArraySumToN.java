import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIndicesOfNumInArraySumToN {
    public static void main(String[] args) {
        int[] arr = {3, 9, 0, 1, 4};
        System.out.println(findIndicesOfNumInArraySumToN(arr, 4));
    }

    static List<List<Integer>> findIndicesOfNumInArraySumToN(int[] arr, int N){
        List<List<Integer>> list= new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            int current = arr[i];
            int comp = N-current;
            if (hm.containsKey(comp)){
                list.add(List.of(hm.get(comp), i));

            }
            hm.put(arr[i], i);
        }
        return list;
    }

}
