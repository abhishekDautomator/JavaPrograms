import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class UniqueRandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> roomNumbers = random
                .ints(0,9)
                .distinct()
                .limit(7)
                .boxed()
                .toList();

        StringBuilder roomNumbersAsString = new StringBuilder();
        for (int n:
             roomNumbers) {
            roomNumbersAsString.append(n);
        }
        System.out.println(roomNumbersAsString.deleteCharAt(roomNumbersAsString.length()-1));
    }
}
