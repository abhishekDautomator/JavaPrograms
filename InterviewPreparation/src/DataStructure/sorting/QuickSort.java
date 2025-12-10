package DataStructure.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[]arr, int l, int r){
        if(l<r){
            int p = partition(arr, l, r);
            quickSort(arr, l, p-1);
            quickSort(arr, p+1, r);
        }
    }

    public static int partition(int[] arr, int l, int r){
        int p = arr[r];
        int j = l;
        for(int i=l; i<r; i++) {
            if (arr[i] <= p) {
                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                j++;
            }
        }
        int temp2 = arr[j];
        arr[j] = arr[r];
        arr[r] = temp2;
        return j;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 9, 8, 2, 4,7};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
