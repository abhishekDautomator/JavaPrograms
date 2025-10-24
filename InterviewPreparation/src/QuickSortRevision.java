import java.util.Arrays;

public class QuickSortRevision {

    public static void quickSorting(int[] arr, int left, int right){
        if(left<right){
            int p = partition(arr, left, right);
            quickSorting(arr, left, p-1);
            quickSorting(arr, p+1, right);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int p = arr[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if(arr[i]<=p){
                int temp1 = arr[i];
                arr[i]=arr[j];
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
        quickSorting(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
