import java.util.ArrayList;
import java.util.List;

public class FindTheSubarraysAddUptToN {
    public static void main(String[] args) {
        int[] arr = {-3,-2,1,2,4,5};
        int target = 1;
        System.out.println(findTheSubArraysOfSumN(arr, target));
    }

    static List<List<Integer>> findTheSubArraysOfSumN(int[] arr, int target){
        List<List<Integer>> resultList = new ArrayList<>();

        for (int start = 0; start < arr.length; start++) {
            int sum = 0;
            List<Integer> currentSubarray = new ArrayList<>();

            for (int end = start; end < arr.length; end++) {
                sum += arr[end];
                currentSubarray.add(arr[end]);

                if (sum == target) {
                    resultList.add(new ArrayList<>(currentSubarray));
                }
            }
        }

        return resultList;
    }
}
