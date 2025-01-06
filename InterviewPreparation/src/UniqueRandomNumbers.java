import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class UniqueRandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> roomNumbers = random
                .ints(0,100)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
        StringBuilder roomNumbersAsString = new StringBuilder();
        for (int n:
             roomNumbers) {
            roomNumbersAsString.append(n).append(",");
        }
        System.out.println(roomNumbersAsString.deleteCharAt(roomNumbersAsString.length()-1));
    }
}
