package DataStructure.map.TreeMap;

import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> scoreBoard = new TreeMap<>();

        // Adding entries
        scoreBoard.put(56, "Raj");
        scoreBoard.put(95, "Priya");
        scoreBoard.put(100, "Abhishek");
        scoreBoard.put(85, "Neha");

        // Sorted output
        System.out.println("🏆 Leaderboard:");
        for (Map.Entry<Integer, String> entry : scoreBoard.descendingMap().entrySet()) {
            System.out.println(entry.getValue() + " scored " + entry.getKey());
        }

        // Range queries
        System.out.println("\n🎯 Nearest score to 93: " + scoreBoard.ceilingEntry(93));
        System.out.println("📈 Top scorer: " + scoreBoard.lastEntry());
        System.out.println("📉 Lowest scorer: " + scoreBoard.firstEntry());

        //custom Comparator
        TreeMap<String, Integer> nameMap = new TreeMap<>(Comparator.reverseOrder());
        nameMap.put("Raj", 1);
        nameMap.put("Abhishek", 2);
        nameMap.put("Priya", 3);
        System.out.println(nameMap); // Sorted in reverse alphabetical order

        //range queries
        TreeMap<Integer, String> stockPrices = new TreeMap<>();
        stockPrices.put(90, "Low");
        stockPrices.put(120, "Moderate");
        stockPrices.put(150, "Stable");
        stockPrices.put(180, "Rising");
        stockPrices.put(210, "High");

        // Get prices between ₹100 and ₹200
        SortedMap<Integer, String> range = stockPrices
                .subMap(100, true, 200, true);

        System.out.println("📊 Prices in range ₹100–₹200:");
        range.forEach((price, status) ->
                System.out.println("₹" + price + " → " + status));

        // Prefix related filter
        TreeMap<String, String> nameDirectory = new TreeMap<>();
        nameDirectory.put("Abhishek", "Engineer");
        nameDirectory.put("Abhinav", "Designer");
        nameDirectory.put("Aditi", "Manager");
        nameDirectory.put("Ajay", "Analyst");
        nameDirectory.put("Ankit", "Tester");

        // Define prefix
        String prefix = "Ab";
        String endPrefix = prefix + Character.MAX_VALUE;

        // Get names starting with "Ab"
        SortedMap<String, String> matches = nameDirectory.subMap(prefix, true, endPrefix, true);

        System.out.println("🔍 Names starting with '" + prefix + "':");
        matches.forEach((name, role) -> System.out.println(name + " → " + role));
    }
}
