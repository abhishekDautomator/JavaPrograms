import java.util.ArrayList;
import java.util.List;

public class FindTheSubsetsAddUpToN {

    public static void main(String[] args) {
        int[] arr = {-3,-2,1,2,4,5};
        int target = 1;
        System.out.println(findTheSubsetsOfSumN(arr, target));
    }

    static List<List<Integer>> findTheSubsetsOfSumN(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, target, 0, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[] arr, int target, int index,
                          List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // found a valid subset
            return;
        }
        if (index >= arr.length) return;

        // Choice 1: include arr[index]
        current.add(arr[index]);
        backtrack(arr, target - arr[index], index + 1, current, result);
        current.remove(current.size() - 1);

        // Choice 2: exclude arr[index]
        backtrack(arr, target, index + 1, current, result);
    }
}
