import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MaxPackages {
    public static void main(String[] args) {
        int[] cost = {1, 2, 3, 4, 5}; // Example input
        System.out.println(maxPackages(cost));
    }
    public static int maxPackages(int[] cost) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Count the frequency of each item cost
        for (int c : cost) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        int maxPackages = 0;
        // Check all possible target costs
        for (Integer targetCost : frequencyMap.keySet()) {
            // Packages formed by single items
            int singlePackages = frequencyMap.get(targetCost); // Each item can form a single package
            maxPackages += singlePackages;
            // Packages formed by pairs
            int pairPackages = 0;
            for (Integer otherCost : frequencyMap.keySet()) {
                if (!Objects.equals(otherCost, targetCost)) {
                    int combinedCost = targetCost + otherCost;
                    if (frequencyMap.containsKey(combinedCost)) {
                        int pairs = Math.min(frequencyMap.get(targetCost), frequencyMap.get(otherCost));
                        pairPackages += pairs;
                    }
                }
            }
            maxPackages = Math.max(maxPackages, pairPackages);
        }
        return maxPackages;
    }
}
