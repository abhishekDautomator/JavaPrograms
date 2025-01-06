package Java8;

import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;

public class OperatorExample {
    //`UnaryOperator` and `BinaryOperator` are specialized functional interfaces in Java 8.
    // They are used for operations where input and output types are the same:
    //- `UnaryOperator` operates on a single operand (like `x -> x * 2` for multiplication).
    //- `BinaryOperator` operates on two operands (like `x + y` for addition).
    public static void main(String[] args) {
        // Using UnaryOperator to double a number
        UnaryOperator<Integer> doubleFunction = x -> x * 2;
        System.out.println("Double of 5 is: " + doubleFunction.apply(5));

        // Using BinaryOperator to add two numbers
        BinaryOperator<Integer> additionFunction = (x, y) -> x + y;
        System.out.println("Sum of 5 and 10 is: " + additionFunction.apply(5, 10));

        // Explanation:
        // 1. UnaryOperator takes a single input `x` and returns a single output (doubles the input here).
        // 2. BinaryOperator takes two inputs, performs the operation (addition in this case), and returns the result.

        // More complex usage can be done with these operators on collections and streams.
    }
}