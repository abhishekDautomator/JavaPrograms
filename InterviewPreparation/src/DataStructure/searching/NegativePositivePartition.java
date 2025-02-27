package DataStructure.searching;

import java.util.*;

public class NegativePositivePartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        partitionNegativeAndPositive(n, arr);
    }

    // Method to partition negative and positive numbers without comparing with 0
    static void partitionNegativeAndPositive(int n, int[] arr) {
        List<Integer> posList = new ArrayList<Integer>();
        List<Integer> negList = new ArrayList<Integer>();

        for (int i : arr) {
            if (i < 0) negList.add(i);
            else posList.add(i);
        }

        if (arr[0] < 0) {
            if (posList.isEmpty()) {
                System.out.println(negList);
                System.out.println("Array doesn't have positive numbers");
            } else {
                System.out.println(negList);
                System.out.println(posList);
            }
        } else {
            if (negList.isEmpty()) {
                System.out.println(posList);
                System.out.println("Array doesn't have negative numbers");
            } else {
                System.out.println(negList);
                System.out.println(posList);
            }
        }
    }
}
