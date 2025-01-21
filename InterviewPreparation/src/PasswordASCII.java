import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordASCII {
    public static void main(String[] args) {
        String input = "796115110113721110141108";
        String decodedPassword = getAllDigitAsciiChar(input);
        System.out.println(decodedPassword);
    }

    static String getAllDigitAsciiChar(String s){
        StringBuilder reverse = new StringBuilder(s).reverse();
        StringBuilder result = new StringBuilder();

        int i = 0;
        while(i<reverse.length()){
            if(i+2<reverse.length()){
                int threeDigit = Integer.parseInt(reverse.substring(i, i+3));
                if(threeDigit>=100 && threeDigit<=122){
                    result.append((char) threeDigit);
                    i+=3;
                    continue;
                }
            }
            if(i+1<reverse.length()){
                int twoDigit = Integer.parseInt(reverse.substring(i, i+2));
                if((twoDigit>=65 && twoDigit<=90) || (twoDigit>=97 && twoDigit<=99) || twoDigit==32){
                    result.append((char) twoDigit);
                    i+=2;
                    continue;
                }
                i++;
            }

        }
        return result.toString();
    }
}
