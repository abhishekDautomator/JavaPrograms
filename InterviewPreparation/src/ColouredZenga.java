import java.util.*;

public class ColouredZenga {

    public static int minMoves(int N, String[] blocks) {
        if (blocks.length == 0) {
            return 0;
        }

        // Step 1: Group consecutive blocks
        int groupCount = 1;
        String currentColor = blocks[0];
        for (int i = 1; i < blocks.length; i++) {
            if (!blocks[i].equals(currentColor)) {
                groupCount++;
                currentColor = blocks[i];
            }
        }

        // Step 2: Calculate the minimum number of steps
        // Each step can remove two groups if they are of the same color after collapsing
        return (groupCount + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of blocks:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String[] blocks = new String[n];

        System.out.println("Enter the colors of the blocks (red or white):");
        for (int i = 0; i < n; i++) {
            blocks[i] = scanner.nextLine().trim();
        }

        int result = minMoves(n, blocks);
        System.out.println(result);

        scanner.close();
    }
}
