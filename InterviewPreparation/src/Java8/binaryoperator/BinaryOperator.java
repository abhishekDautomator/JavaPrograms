package Java8.binaryoperator;

import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;


public class BinaryOperator {
    public static void main(String[] args) {
        DoubleBinaryOperator aToPowerB = (a, b) -> Math.pow(2,5);
        System.out.println("A to the power of B : "+aToPowerB.applyAsDouble(2,5));
    }
}
