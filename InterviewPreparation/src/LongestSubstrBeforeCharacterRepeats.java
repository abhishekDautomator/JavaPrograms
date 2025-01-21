import java.util.*;

public class LongestSubstrBeforeCharacterRepeats {
    public static void main(String[] args) {
        System.out.println(findTheSubSTring("sjahvhjasbchghehhhhhxsywuakkahahbxb"));
    }
    public static String findTheSubSTring(String str){
        List<String> stringList = new ArrayList<>();
        StringBuilder sub= new StringBuilder();
        for(int i=0;i<=str.length()-2;i++){
            if(str.charAt(i)!=str.charAt(i+1)) {
                sub.append(str.charAt(i));
                if (i == str.length() - 2) {
                    sub.append(str.charAt(i + 1));
                    stringList.add(sub.toString());
                }
            }
            else{
                sub.append(str.charAt(i));
                stringList.add(sub.toString());
                if(i == str.length() - 2)
                    stringList.add(String.valueOf(str.charAt(i+1)));
                sub = new StringBuilder();
            }
        }
        System.out.println("List: "+stringList);
        return stringList.stream().max(Comparator.naturalOrder()).orElse("");
    }
}
