package DataStructure.sorting;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 9, 8, 2, 4,7};
        selectionSort(array);
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
