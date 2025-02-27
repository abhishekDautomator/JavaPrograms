package Java8.supplier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Date> supplierToGetCurrentDate = Date::new;

        Supplier<Integer> supplierToGetRandom4DigitNum = () -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                result.append((int) (Math.random() * 9));
            }
            return Integer.parseInt(result.toString());
        };

        Supplier<String> password = () -> {
            StringBuilder s = new StringBuilder();
            for (int i = 1; i <=8; i++) {
                if(i%2!=0) {
                    char rChar = (char) (new Random().nextInt(26) + 'A');
                    String rString = rChar+"@"+"#"+"$";
                    s.append(rString.charAt(new Random().nextInt(rString.length())));
                }
                else
                    s.append((int) (Math.random() * 9));
            }
            return s.toString();
        };

        System.out.println("Current date : "+supplierToGetCurrentDate.get());
        System.out.println("Random 4 digit number : "+supplierToGetRandom4DigitNum.get());
        System.out.println("Random 8 character password generated : "+password.get());
    }
}