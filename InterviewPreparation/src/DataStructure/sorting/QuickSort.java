package DataStructure.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[]arr, int start, int end){
        if(start<end){
            int p = partition(arr, start, end);
            quickSort(arr, start, p-1);
            quickSort(arr, p+1, end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int p = arr[end];
        int j = start;
        for(int i=start; i<end; i++) {
            if (arr[i] <= p) {
                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                j++;
            }
        }
        int temp2 = arr[j];
        arr[j] = arr[end];
        arr[end] = temp2;
        return j;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 9, 8, 2, 4,7};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
