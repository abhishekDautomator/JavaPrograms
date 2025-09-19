import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTripletInAnArraySumToN {
    public static void main(String[] args){
        int[] arr = {-3,-2,1,2,4,5};
        int target = 0;
        System.out.println("Below are the triplets in arr: "+Arrays.toString(arr)+" are: "+findTripletInAnArraySumToN(arr, target));
    }

    static List<List<Integer>> findTripletInAnArraySumToN(int[] numArr, int target){
        if(numArr.length<3){
            throw new RuntimeException("Array should have at least 3 integers to process");
        }
        List<List<Integer>> tripletList = new ArrayList<>();
        if(numArr.length==3 && numArr[0]+numArr[1]+numArr[2]==target) {
            tripletList.add(List.of(numArr[0],numArr[1],numArr[2]));
            return tripletList;
        }
        Arrays.sort(numArr);

        for(int i=0; i<numArr.length;i++){
            if(i>0 && numArr[i]==numArr[i-1]) continue;

            int l = i+1;
            int r = numArr.length-1;

            while(l<r){
                int sumOfTriplet = numArr[i]+numArr[l]+numArr[r];
                if(sumOfTriplet==target) {
                    tripletList.add(List.of(numArr[i], numArr[l], numArr[r]));
                    l++;
                    r--;
                    while (l < r && numArr[l] == numArr[l - 1]) {
                        l++;
                    }
                    while(l<r && numArr[r] == numArr[r + 1]) {
                        r--;
                    }
                }else if(sumOfTriplet<target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return tripletList;
    }
}
