package Java8.supplier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Date> supplierToGetCurrentDate = () -> {
            return new Date();
        };

        Supplier<Integer> supplierToGetRandom4DigitNum = () -> {
            String result = "";
            for (int i = 0; i < 4; i++) {
                result+=(int)(Math.random()*9);
            }
            return Integer.parseInt(result);
        };

        Supplier<String> password = () -> {
            String s = "";
            for (int i = 1; i <=8; i++) {
                if(i%2!=0) {
                    char rChar = (char) (new Random().nextInt(26) + 'A');
                    String rString = rChar+"@"+"#"+"$";
                    s+=rString.charAt(new Random().nextInt(rString.length()));
                }
                else
                    s+= (int)(Math.random()*9);
            }
            return s;
        };

        System.out.println("Current date : "+supplierToGetCurrentDate.get());
        System.out.println("Random 4 digit number : "+supplierToGetRandom4DigitNum.get());
        System.out.println("Random 8 character password generated : "+password.get());
    }
}