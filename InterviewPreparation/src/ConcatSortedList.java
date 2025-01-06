import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatSortedList {
    public static void main(String[] args) {
        List<String> query = new ArrayList<>();
        query.add("Abhishek");
        for (String sq : query) {
            String sQ = Arrays.stream(sq.split("")).sorted().map(ch -> ch.substring(0, 1)).collect(Collectors.joining());
        }
    }
}
