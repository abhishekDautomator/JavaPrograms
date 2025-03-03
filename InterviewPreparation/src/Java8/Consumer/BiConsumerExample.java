package Java8.Consumer;

import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer =
                (s1, s2) -> System.out.println("Full name is "+s1+" "+s2);

        biConsumer.accept("Abhishek","Narayan");
    }
}
