package DataStructure.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSorting(int[] arr, int left, int right) {
        if(left<right) {
            int mid = (left + right) / 2;
            mergeSorting(arr, left, mid);
            mergeSorting(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int l = mid - left + 1;
        int r = right - mid;

        int[] leftArr = new int[l];
        int[] rightArr = new int[r];

        for (int i = 0; i < l; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < r; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < l && j < r) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i<l) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j<r) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    public void mergeSortRevision(int[] arr, int l, int r){
        if(l<r){
            int mid = l + (r-l)/2;
            mergeSortRevision(arr, l, mid);
            mergeSortRevision(arr, mid+1, r);
            merge(arr,l,mid,r);
        }
    }

    public void mergeArr(int[] arr, int left, int mid, int right){
        int l = mid - left +1;
        int r = right - mid;

        int[] leftArr = new int[l];
        int[] rightArr = new int[r];

        for(int i=0;i<l;i++){
            leftArr[i] = arr[left+i];
        }

        for(int i=0;i<r;i++){
            rightArr[i] = arr[mid+1+i];
        }

        int i=0,j=0,k=left;

        while(i<l && j<r){
            if(leftArr[i]<=rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
            }
            k++;
        }

        while(i<l){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j<r){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 9, 8, 2, 4,7};
        mergeSorting(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
