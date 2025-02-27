package DataStructure.searching;

public class MatrixBinarySearch {

    public static boolean matrixBinarySearch(int[][] matrix, int target){
        if(matrix == null || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n - 1;

        while(left<=right){
            int mid = left + (right-left)/2;
            int midVal = matrix[mid/n][mid%n]; //convert mid to 2D index
            if(midVal==target) return true;
            else if(midVal<target)  left = mid+1;
            else right = mid -1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = MatrixBinarySearch.matrixBinarySearch(matrix, target);
        System.out.println(result);
    }
}
