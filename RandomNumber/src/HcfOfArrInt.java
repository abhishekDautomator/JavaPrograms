import java.util.Arrays;
import java.util.Scanner;

public class HcfOfArrInt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the elements of the array separated by space");
        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(gcdIntArr(arr));
    }

    public static int gcdIntArr(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = HCForGCD2Num.getGCD(result, arr[i]);
        }
        return result;
    }
}
