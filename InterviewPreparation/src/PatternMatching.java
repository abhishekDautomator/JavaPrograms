import java.util.Set;

public class PatternMatching {
    public static void main(String[] args) {
        String pattern = "010";
        String source = "amazing";

        int i=0, count=0;
        while(i+pattern.length()<=source.length()){
            String sub = source.substring(i,i+pattern.length());
            boolean result = isPatternMatched(pattern,sub);
            System.out.println("substring: "+sub+", matched: "+result);
            if(result) count++;
            i++;
        }
        System.out.println("total substrings matching pattern are: "+count);
    }

    static boolean isPatternMatched(String pattern, String str){
        Set<Character> vowels = Set.of('a','e','i','o','u','y');
        for(int i=0;i< str.length();i++){
            boolean isVowel = vowels.contains(str.charAt(i));
            int b = pattern.charAt(i)-'0';
            if((b==0 && !isVowel) || (b==1 && isVowel) ) return false;
        }
        return true;
    }
}
