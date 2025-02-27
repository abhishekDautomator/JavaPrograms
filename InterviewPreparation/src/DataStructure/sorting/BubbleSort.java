package DataStructure.sorting;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int swap = 0;
            for (int j = 1; j < (arr.length-i); j++) {
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swap = 1;
                }
            }
            if(swap == 0) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 9, 8, 2, 4,7};
        bubbleSort(array);
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
