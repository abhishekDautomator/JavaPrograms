import java.util.*;

public class FindTheSubarraysAddUptToN { //contiguous index subsets only
    public static void main(String[] args) {
        int[] arr = {-3,-2,1,2,4,5};
        int target = 1;
        System.out.println(findTheSubArraysOfSumN(arr, target));
        System.out.println(findTheSubArraysOfSumN2(arr, target));
        System.out.println(findTheSubarraysAddUpToN3(arr, target));
    }

    static List<List<Integer>> findTheSubArraysOfSumN2(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> prefixMap = new HashMap<>();
        prefixMap.put(0, new ArrayList<>(List.of(-1))); // base case

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // Check if (sum - target) has been seen before
            if (prefixMap.containsKey(sum - target)) {
                for (int startIndex : prefixMap.get(sum - target)) {
                    // slice from startIndex+1 to i
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = startIndex + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }

            // Add current index to prefixMap
            prefixMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
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

    static List<List<Integer>> findTheSubarraysAddUpToN3(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> prefixSumMap = new HashMap<>();
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(prefixSumMap.containsKey(sum-target)){
                for(int startIndex: prefixSumMap.get(sum-target)) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = startIndex+1; j <=i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }
            prefixSumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }
}
