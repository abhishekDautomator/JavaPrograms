package DataStructure.searching;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target){
        int i=0;
        for(int t: arr){
            if(t == target) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 9, 8, 2, 4,7};
        int target = 9;

        int index = linearSearch(array, target);
        if(index == -1)
            System.out.println("Target " + target + " not found");
        else
            System.out.println("Target " + target + " found at index "+ index);
    }
}
