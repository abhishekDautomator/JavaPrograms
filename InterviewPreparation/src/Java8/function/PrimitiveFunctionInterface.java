package Java8.function;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class PrimitiveFunctionInterface {
    public static void main(String[] args) {
        IntFunction<Integer> func = n -> n*n;
        System.out.println("Square of number 4 is "+func.apply(4));

        System.out.println();

        ToIntFunction<String> wordLength = String::length;
        System.out.println("Length of the word Abhishek is "+wordLength.applyAsInt("Abhishek"));

        
    }
}
