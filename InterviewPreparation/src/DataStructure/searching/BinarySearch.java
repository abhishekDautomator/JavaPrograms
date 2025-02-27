package DataStructure.searching;

import DataStructure.sorting.MergeSort;

import java.util.Arrays;

public class BinarySearch {
    public static void binarySearchUsingRecursion(int[] arr, int l, int r, int target) {
        //applies only on a sorted array
        if(l>r)
            System.out.println("Start index can't be lower than end index");
        int mid = l + (r-l)/2;
        System.out.println("mid: "+mid);
        System.out.println("arr[mid]: "+arr[mid]);
        if(arr[mid] == target) {
            System.out.println("Target " + target + " found using binarySearchUsingRecursion at index "+ mid);
        }
        else if(arr[mid]>target)
            binarySearchUsingRecursion(arr, l, mid-1, target);
        else
            binarySearchUsingRecursion(arr, mid+1, r, target);
    }

    public static int binarySearchUsingWhileLoop(int[] arr, int l, int r, int target) {
        //applies only on a sorted array
        if(l>r)
            System.out.println("Start index can't be lower than end index");

        while(l<=r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == target) {
               return mid;
            } else if (arr[mid] > target)
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 9, 8, 2, 4,7};
        int target = 2;
        MergeSort.mergeSorting(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        System.out.println("Target number is: "+target);
        binarySearchUsingRecursion(array, 0, array.length-1, target);

        int targetIndex = binarySearchUsingWhileLoop(array, 0, array.length-1, target);
        System.out.println("Target " + target + " found using binarySearchUsingWhileLoop at index "+ targetIndex);
    }
}
