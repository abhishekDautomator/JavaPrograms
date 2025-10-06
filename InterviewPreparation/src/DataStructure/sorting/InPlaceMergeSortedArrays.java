package DataStructure.sorting;

import java.util.Arrays;

public class InPlaceMergeSortedArrays {
    public static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int gap = nextGap(m + n);

        while (gap > 0) {
            int i, j;

            // Compare elements in arr1
            for (i = 0; i + gap < m; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    swap(arr1, i, i + gap);
                }
            }

            // Compare elements between arr1 and arr2
            for (j = gap > m ? gap - m : 0; i < m && j < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            // Compare elements in arr2
            for (j = 0; j + gap < n; j++) {
                if (arr2[j] > arr2[j + gap]) {
                    swap(arr2, j, j + gap);
                }
            }

            gap = nextGap(gap);
        }
    }

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap + 1) / 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeRevision(int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;

        int gap = nextGapRevision(m+n);

        while(gap>0){
            int i,j;
            for (i = 0; i+gap< m; i++) {
                if(arr1[i]>arr1[i+gap])
                    swapRevision(arr1, i, gap+i);
            }

            for (j= gap>m?gap-m:0 ; i<m && j<n; i++,j++) {
                if(arr1[i]>arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            for (j = 0; j+gap< n; j++) {
                if(arr1[j]>arr1[j+gap])
                    swapRevision(arr2, j, gap+j);
            }


            gap = nextGapRevision(gap);
        }


    }

    private static int nextGapRevision(int gap){
        if(gap<=1) return 0;
        return (gap+1)/2;
    }

    private static void swapRevision(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        merge(arr1, arr2);

        System.out.println("Merged arr1: " + Arrays.toString(arr1));
        System.out.println("Merged arr2: " + Arrays.toString(arr2));
    }
}
