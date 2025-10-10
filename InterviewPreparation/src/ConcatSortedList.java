import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatSortedList {
    public static void main(String[] args) {
        List<String> query = new ArrayList<>();
        query.add("Abhishek");
        String sQ = "";
        for (String sq : query) {
            sQ = Arrays.stream(sq.split("")).sorted().collect(Collectors.joining());
        }
        System.out.println("Sorted string is: "+sQ);
    }
}
