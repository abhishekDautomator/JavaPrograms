import java.util.ArrayList;
import java.util.List;

public class FindTheSubarraysAddUptToN {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findTheSubArraysOfSumN(int[] arr, int n){
        int left=0, right=0, sum=0;
        List<Integer> listSumToN = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        while(left<arr.length){
            while(sum+arr[right]<=n){
                sum+=arr[right];
                listSumToN.add(arr[right]);
                right++;
            }
            if(sum==n){
                resultList.add(listSumToN);
                right++;
            }
            left++;
            sum=0;
        }
        return resultList;
    }
}
