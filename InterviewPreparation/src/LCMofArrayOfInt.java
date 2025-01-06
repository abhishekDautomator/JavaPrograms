import java.util.Arrays;
import java.util.Scanner;

public class LCMofArrayOfInt {
    public static void main(String[] args) {
        System.out.println("Enter the length of an array");
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the elements of int array separated by a space");
        scn.nextLine();
        int[] arr = Arrays.stream(scn.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lcm = (lcm * arr[i]) / HCForGCD2Num.getGCD(lcm, arr[i]);
        }

        System.out.println("LCM of the provided array is " + lcm);
    }
}
