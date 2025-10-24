import java.util.HashMap;
import java.util.Map;

class FindSizeOfLargestPossiblePalindrome {
    public static void main(String[] args) {
        char[] charArr = {'a', 'b', 'b', 'c', 'd', 'e', 'e','m', 'p', 'c', 'b', 'd', 'p'}; //Size of the Longest palindrome
        //b - 2, e - 2, d - 2, p - 2, c - 2, a - 1, m - 1, b - 1;

        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : charArr) {
            if (hm.containsKey(c))
                hm.put(c, hm.get(c) + 1);
            else hm.put(c, 1);
        }
        int size = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> e : hm.entrySet()) {
            if (e.getValue() % 2 == 0) {
                size += e.getValue();
            } else flag = true;
        }
        if (flag) size += 1;
        System.out.println("Max size of a palindrome that can be formed is "+size);

    }
}