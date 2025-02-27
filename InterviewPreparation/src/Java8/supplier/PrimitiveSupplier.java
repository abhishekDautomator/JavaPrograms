package Java8.supplier;

import java.util.Random;
import java.util.function.IntSupplier;

public class PrimitiveSupplier {
    public static void main(String[] args) {
        IntSupplier randomIntSupplier = () -> {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                s.append(new Random().nextInt(10));
            }
            return Integer.parseInt(s.toString());
        };
        System.out.println("OTP generated is "+randomIntSupplier.getAsInt());
    }
}
