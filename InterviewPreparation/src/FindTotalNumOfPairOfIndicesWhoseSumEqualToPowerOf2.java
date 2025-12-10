import java.util.*;

public class FindTotalNumOfPairOfIndicesWhoseSumEqualToPowerOf2 {
    public static void main(String[] args) {
        int[] nums1 = {1, -1, 2, 3};
        int numOfPairOfIndices = findTotalPairOfNumIndicesWhoseSumEqualToPowerOf2(nums1);
        System.out.println(numOfPairOfIndices);

        int[] nums2 = {-2, -1, 0, 1, 2};
        List<int[]> pairs2 = findAllPairOfNumIndicesWhoseSumEqualToPowerOf2(nums2);
        for (int[] pair : pairs2) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static int findTotalPairOfNumIndicesWhoseSumEqualToPowerOf2(int[] arr){
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        // Precompute powers of 2 up to safe limit
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i <= 31; i++) { // 2^31 fits in int
            powers.add(1 << i);
        }

        for (int x : arr) {
            // Check pairs (x, y) with y already seen
            for (int p : powers) {
                int y = p - x;
                if (freq.containsKey(y)) {
                    count += freq.get(y);
                }
            }

            // Add x to frequency map
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Handle self-pairs (i == j)
        for (int x : arr) {
            if (PowerOf2.isPower2(2 * x)) {
                count++;
            }
        }

        return count;
    }

    public static List<int[]> findAllPairOfNumIndicesWhoseSumEqualToPowerOf2(int[] arr){
        Map<Integer, List<Integer>> lookup = new HashMap<>();
        List<int[]> resultList = new ArrayList<>();
        int count = 0;

        // Precompute powers of 2 up to safe limit
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i <= 31; i++) { // 2^31 fits in int
            powers.add(1 << i);
        }

        for (int i=0;i<arr.length;i++) {
            // Check pairs (x, y) with y already seen
            int x = arr[i];
            for (int p : powers) {
                int y = p - x;
                if (lookup.containsKey(y)) {
                    for(int j:lookup.get(y)) {
                        resultList.add(new int[]{j, i}); //j<i
                    }
                }
            }

            // Add x to frequency map
            lookup.computeIfAbsent(x, k-> new ArrayList<>()).add(i);
        }

        // Handle self-pairs (i == j)
        for (int i=0;i< arr.length;i++) {
            if (PowerOf2.isPower2(2 * arr[i])) {
                resultList.add(new int[]{i,i});
            }
        }

        return resultList;
    }

}
