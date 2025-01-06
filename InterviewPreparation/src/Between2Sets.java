import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int lcmArr1 = a.get(0);

        for (int i = 1; i < a.size(); i++) {
            lcmArr1 = (lcmArr1 * a.get(i)) / gcd(lcmArr1, a.get(i));
        }

        int count = 0;

        while (lcmArr1 <= b.get(0)) {
            boolean flag = true;
            for (int j : b) {
                if (j % lcmArr1 != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
            lcmArr1 *= 2;
        }

        return count;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else {
            return gcd(b, a % b);
        }
    }
}

public class Between2Sets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        System.out.println(total);

        bufferedReader.close();
    }
}
