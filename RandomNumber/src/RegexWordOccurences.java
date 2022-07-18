import java.util.*;
import java.util.regex.*;

public class RegexWordOccurences {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int nSentences = scan.nextInt();
        System.out.println("nsentences : "+nSentences);
        scan.nextLine();
        List<String> l = new ArrayList<>();
        for (int i = 0; i < nSentences; i++) {
            l.add(scan.nextLine());
        }
        System.out.println("l : "+l);
        int nWord = scan.nextInt();
        System.out.println("nword : "+nWord);
        scan.nextLine();
        List<String> lWord = new ArrayList<>();
        for (int i = 0; i < nWord; i++) {
            lWord.add(scan.nextLine());
        }
        scan.close();
        System.out.println("lword : "+lWord);
        for(String s : lWord){
            System.out.println("Inside word loop");
            int count = 0;
            for(String senString: l){
                Pattern p=Pattern.compile("\\b"+s+"\\b");
                Matcher m=p.matcher(senString);
                while(m.find()){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}