package DesignPatterns.BehavioralPattern.Strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {45, 89 ,23, 101, 57, 2};

        SortingStrategy bubbleShort = new BubbleSort();
        SortingStrategyDesignImpl sortingStrategyDesign = new SortingStrategyDesignImpl(bubbleShort);
        sortingStrategyDesign.performSorting(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {90, 89 ,21, 10, 57, 2};

        SortingStrategy quickShort = new QuickSort();
        SortingStrategyDesignImpl sortingStrategyDesign1 = new SortingStrategyDesignImpl(quickShort);
        sortingStrategyDesign1.performSorting(array2);
        System.out.println(Arrays.toString(array2));
    }
}
