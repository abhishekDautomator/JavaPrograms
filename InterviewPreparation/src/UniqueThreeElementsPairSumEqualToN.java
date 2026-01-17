import java.util.*;

public class UniqueThreeElementsPairSumEqualToN {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        List<List<Integer>> result2 = threeSum2ndWay(nums);
        System.out.println("1st way: "+result);
        System.out.println("2nd way: "+result2);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            for(int j = i+1;j<nums.length;j++){
                int comp = target - nums[j];
                if(set.contains(comp)){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], comp);
                    Collections.sort(triplet);
                    resultSet.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(resultSet);
    }

    public static List<List<Integer>> threeSum2ndWay(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultSet = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length -1;
            while (left<right) {
                int n = nums[i]+nums[left]+nums[right];
                if (n == 0) {
                    resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                } else if (n < 0) {
                    left++;

                } else {
                    right--;
                }
            }
        }
        return resultSet;
    }
}
