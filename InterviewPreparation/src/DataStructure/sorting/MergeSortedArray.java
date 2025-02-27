package DataStructure.sorting;

import java.util.Arrays;

public class MergeSortedArray {

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int l = a.length, r = b.length, k = 0, i = 0, j = 0;
        int[] c = new int[l + r];
        if (a[0] > a[1]) { //check if array a and b are sorted in desc or asc order
            while (i < l && j < r) {
                if (b[j] <= a[i]) {
                    c[k] = a[i];
                    i++;
                } else {
                    c[k] = b[j];
                    j++;
                }
                k++;
            }

            while (i < l) {
                c[k] = a[i];
                i++;
                k++;
            }

            while (j < r) {
                c[k] = b[j];
                j++;
                k++;
            }

        }else{
            while (i < l && j < r) {
                if (b[b.length-j-1] <= a[a.length-i-1]) {
                    c[k] = a[a.length-i-1];
                    i++;
                } else {
                    c[k] = b[b.length-j-1];
                    j++;
                }
                k++;
            }

            while (i < l) {
                c[k] = a[a.length-i-1];
                i++;
                k++;
            }

            while (j < r) {
                c[k] = b[b.length-j-1];
                j++;
                k++;
            }

        }
        return c;
    }



    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5, 6, 7};

        System.out.println("arr1: "+ Arrays.toString(arr1));
        System.out.println("arr2: "+ Arrays.toString(arr2));
        System.out.println("Merged array of the above sorted arrays in descending order is: "+Arrays.toString(mergeSortedArrays(arr1, arr2)));
    }
}
