import java.util.*;

public class OddEvenSequence {
    public static List<Integer> maintainOddEvenSequence(List<Integer> input) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        for (int num : input) {
            if (num % 2 != 0) {
                oddList.add(num);
            } else {
                evenList.add(num);
            }
        }

        // Combine odd and even lists
        oddList.addAll(evenList);
        return oddList;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 8, 5, 12, 7, 6, 9, 4);
        List<Integer> result = maintainOddEvenSequence(input);
        System.out.println("Odd-Even Sequence: " + result);
    }
}