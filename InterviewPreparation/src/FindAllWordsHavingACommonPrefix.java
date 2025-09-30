import java.util.*;

public class FindAllWordsHavingACommonPrefix{
    public static void main(String[] args) {
        TreeSet<String> wordList = new TreeSet<>();
        wordList.add("Abhishek");
        wordList.add("Abhilasha");
        wordList.add("Abha");
        wordList.add("Anu");
        wordList.add("Dhriti");

        String prefix = "Ab";
        String endOfPrefix = prefix+Character.MAX_VALUE;

        Set<String> range = wordList.subSet(prefix, true, endOfPrefix, true);

        System.out.println("📊 Words having prefix 'Ab' are :");
        range.forEach(System.out::println);

    }
}