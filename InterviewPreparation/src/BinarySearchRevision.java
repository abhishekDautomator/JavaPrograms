import DataStructure.sorting.MergeSort;

import java.util.Arrays;

public class BinarySearchRevision {

    public static void main(String[] args) {
        int[] array = {2,4,5,7,9};
        int target = 3;
        MergeSort.mergeSorting(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("Target number is: " + target);
        System.out.println("Is target present in the array: "+binarySearch(array, 0, array.length - 1, target));
        System.out.println("Is target present in the array: "+binarySearchUsingWhileLoop(array, 0, array.length - 1, target));
    }

    public static boolean binarySearch(int[] arr, int l, int r, int target){
        if(l>r) return false;
        int mid = l + (r-l)/2;
        if(arr[mid]==target) return true;
        else if (arr[mid]<target) {
            return binarySearch(arr, mid+1, r, target);
        }
        return binarySearch(arr,l, mid-1, target);
    }

    public static boolean binarySearchUsingWhileLoop(int[] arr, int l, int r, int target){
        if(l>r) return false;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid]==target) return true;
            else if (arr[mid]<target) l = mid+1;
            else r = mid -1;
        }
        return false;
    }
}
