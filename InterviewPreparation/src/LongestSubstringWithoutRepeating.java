import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String input = "abcabcbb";
        String result = longestSubStr(input);
        System.out.println("Longest substring without repeating characters: " + result);
    }

    public static String longestSubStr(String str){
        Set<Character> charset = new HashSet<>();
        int left = 0, startIndex=0, maxLength=0;

        for(int right=0; right<str.length(); right++){
            while(charset.contains(str.charAt(right))){
                charset.remove(str.charAt(left));
                left++;
            }

            charset.add(str.charAt(right));

            if(right-left+1>maxLength) {
                maxLength = right - left + 1;
                startIndex=left;
            }
        }
        return str.substring(startIndex, startIndex+maxLength);
    }
}
