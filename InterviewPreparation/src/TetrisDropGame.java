import java.util.*;

public class TetrisDropGame {

    public static int solution(int[][] field, int[][] figure) {
        int height = field.length;
        int width = field[0].length;

        // Possible starting positions for the figure
        for (int startCol = 0; startCol <= width - 3; startCol++) {
            // Copy field to simulate drop
            int[][] tempField = deepCopy(field);

            // Drop the figure
            int row = 0;
            while (row + 3 <= height) {
                if (collides(tempField, figure, row, startCol)) {
                    break; // collision detected, stop before overlap
                }
                row++;
            }
            row--; // step back to last valid position

            if (row >= 0) {
                placeFigure(tempField, figure, row, startCol);

                // Check if any row is fully filled
                if (hasFullRow(tempField)) {
                    return startCol;
                }
            }
        }
        return -1;
    }

    // Check collision at given position
    private static boolean collides(int[][] field, int[][] figure, int row, int col) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (figure[i][j] == 1) {
                    if (row + i >= field.length || field[row + i][col + j] == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Place figure into field
    private static void placeFigure(int[][] field, int[][] figure, int row, int col) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (figure[i][j] == 1) {
                    field[row + i][col + j] = 1;
                }
            }
        }
    }

    // Check if any row is fully filled
    private static boolean hasFullRow(int[][] field) {
        for (int[] r : field) {
            boolean full = true;
            for (int cell : r) {
                if (cell == 0) {
                    full = false;
                    break;
                }
            }
            if (full) return true;
        }
        return false;
    }

    // Deep copy helper
    private static int[][] deepCopy(int[][] field) {
        int[][] copy = new int[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            copy[i] = Arrays.copyOf(field[i], field[i].length);
        }
        return copy;
    }

    // Demo
    public static void main(String[] args) {
        int[][] field1 = {
                {0,0,0},
                {0,0,0},
                {0,0,0},
                {1,0,0},
                {1,1,0}
        };
        int[][] figure1 = {
                {0,0,1},
                {0,1,1},
                {0,0,1}
        };
        System.out.println(solution(field1, figure1)); // 0

        int[][] field2 = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,1,0,1,0},
                {1,0,1,0,1}
        };
        int[][] figure2 = {
                {1,1,1},
                {1,0,1},
                {1,0,1}
        };
        System.out.println(solution(field2, figure2)); // 2

        int[][] field3 = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {1,0,0,1},
                {1,1,0,1}
        };
        int[][] figure3 = {
                {1,1,0},
                {1,0,0},
                {1,0,0}
        };
        System.out.println(solution(field3, figure3)); // -1
    }
}
