package Java8.Consumer;

import java.util.function.IntConsumer;

public class PrimitiveConsumer {
    public static void main(String[] args) {
        IntConsumer i = num -> {
            System.out.println("Square of input is "+(num*num));
        };
        i.accept(10);
    }
}
