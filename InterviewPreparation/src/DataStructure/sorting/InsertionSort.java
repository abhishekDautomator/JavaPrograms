package DataStructure.sorting;

public class InsertionSort {
    public static void doInsertionSorting(int[] arr){
        for(int i=1; i<arr.length; i++){
            int j=i;
            int v=arr[i];
            while(j>=1 && arr[j-1]>v){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=v;
        }
    }

    public static void doInsertionSortingReverse(int[] arr){
        for(int i=arr.length-2;i>=0;i--){
            int j=i;
            int v=arr[i];
            while(j<=arr.length-2 && arr[j+1]>v){
                arr[j]=arr[j+1];
                j++;
            }
            arr[j]=v;
        }
    }

    public static void insertionSortingRevision(int[] arr){
        for(int i=0;i<arr.length;i++){
            int j=i;
            int v=arr[i];
            while(j>=1 && arr[j-1]>v){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=v;
        }
    }


    public static void main(String[] args) {
        int[] array = {5, 3, 1, 9, 8, 2, 4,7};
        doInsertionSorting(array);
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
        doInsertionSortingReverse(array);
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
