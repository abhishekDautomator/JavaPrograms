import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindLeadersInAnArray {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println("Leaders in  the array: "+ findLeaders(arr));
    }

    public static List<Integer> findLeaders(int[] arr){
        List<Integer> leaders = new ArrayList<>();
        int n=arr.length;
        int maxFromRight = arr[n-1];
        leaders.add(maxFromRight);
        for(int i=n-2; i>=0; i--){
            if(arr[i]>=maxFromRight){
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }
        return leaders.stream().sorted(Comparator.reverseOrder()).toList();
    }
}
