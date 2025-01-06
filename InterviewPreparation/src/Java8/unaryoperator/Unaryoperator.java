package Java8.unaryoperator;

import java.util.function.IntUnaryOperator;

public class Unaryoperator {
    public static void main(String[] args) {
        IntUnaryOperator squareOfNum = num -> num*num;
        System.out.println("Square of the number 10 is "+squareOfNum.applyAsInt(10));
    }
}
