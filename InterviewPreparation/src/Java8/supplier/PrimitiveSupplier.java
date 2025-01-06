package Java8.supplier;

import java.util.Random;
import java.util.function.IntSupplier;

public class PrimitiveSupplier {
    public static void main(String[] args) {
        IntSupplier randomIntSupplier = () -> {
            String s = "";
            for (int i = 0; i < 6; i++) {
                s+=new Random().nextInt(10);
            }
            return Integer.parseInt(s);
        };
        System.out.println("OTP generated is "+randomIntSupplier.getAsInt());
    }
}
