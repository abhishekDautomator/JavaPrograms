package DesignPatterns.BehavioralPattern.Strategy;

public class SortingStrategyDesignImpl {
    private SortingStrategy sortingStrategy;

    public SortingStrategyDesignImpl(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSorting(int[] array){
        sortingStrategy.sort(array);
    }
}
