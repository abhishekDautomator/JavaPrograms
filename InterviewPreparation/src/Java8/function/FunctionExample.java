package Java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A bhishek Narayan");
        list.add(" A bhishek ");
        list.add("A Narayan");
        Function<String, Integer> f = s -> s.trim().replaceAll(" ","").length();
        Function<String, Integer> numSpaces = s -> s.length() - s.trim().replaceAll(" ","").length();
        System.out.println("Length of the characters in the people name is : ");
        for (String s:
             list) {
            System.out.println("Length : "+f.apply(s));
        }
        System.out.println();
        System.out.println("Number of spaces in names are ");
        for (String s:
                list) {
            System.out.println("Length : "+numSpaces.apply(s));
        }
    }
}
