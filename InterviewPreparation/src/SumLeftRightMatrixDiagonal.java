public class SumLeftRightMatrixDiagonal {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] result = sumLeftRightDiagonal(matrix);
        System.out.println("Left Diagonal Sum: " + result[0]);
        System.out.println("Right Diagonal Sum: " + result[1]);
    }

    public static int[] sumLeftRightDiagonal(int[][] matrix){
        int n = matrix.length;
        int sumLeftDiagonal=0, sumRightDiagonal = 0;
        for(int i=0;i<n;i++){
            sumLeftDiagonal+=matrix[i][i];
            sumRightDiagonal+=matrix[n-i-1][i];
        }
        return new int[]{sumLeftDiagonal, sumRightDiagonal};
    }
}
