import java.util.Arrays;

public class FindStringStartWithNum {
    public static void main(String[] args){
        String[] arr = {"One", "2wo", "3hree", "Four", "5ive", "Six"};
        for(String s:arr){
            if(s.substring(0,1).matches("[0-9]"))
                System.out.println(s);
        }
        Arrays.stream(arr)
                .filter(s->s.substring(0,1).matches("[0-9]"))
                .forEach(System.out::println);
    }
}
