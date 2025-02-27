package Java8;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class SumOfTwoNumUsingJava8 {
    public static void main(String[] args) {
        IntBinaryOperator sumOfTwoNum = Math::addExact;
        System.out.println("Sum of A and B using IntBinaryOperator is: "+ sumOfTwoNum.applyAsInt(2, 3));

        BiFunction<Integer, Integer, Integer> sumOfTwoNum2 = Integer::sum;
        System.out.println("Sum of A and B using BiFunction is: "+ sumOfTwoNum2.apply(2, 3));

        BiConsumer<Integer, Integer> sumOfTwoNum3 = (a, b) -> System.out.println("Sum of A and B using BiConsumer is: "+(a+b));
        sumOfTwoNum3.accept(2, 3);

        OptionalInt optionalSum = Arrays.stream(new int[]{2, 3}).reduce(Integer::sum);
        optionalSum.ifPresent(sum -> System.out.println("Sum of A and B using Optional is: " + sum));

        int sumUsingStream = Arrays.stream(new int[]{2, 3}).sum();
        System.out.println("Sum of A and B using Stream API is: " + sumUsingStream);
    }
}
