import java.util.Scanner;

public class ASCIIToStringConversion {

    static String asciiToString(String[] asciiNumArray){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < asciiNumArray.length; i=i+2) {
            String current = asciiNumArray[i]+asciiNumArray[i+1];
            int n = Integer.parseInt(current);
            if(n==32)
                result.append(" ");
            else if(n>64 && n<91 || n>96 && n<100)
                result.append((char)n);
            else{
                if(i+2>asciiNumArray.length)
                    break;
                else{
                    current+=asciiNumArray[i+2];
                    n = Integer.parseInt(current);
                    result.append((char)n);
                    i++;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strAscii = sc.next();

        StringBuilder strRevAscii = new StringBuilder(strAscii);
        String[] revStrArr= strRevAscii.reverse().toString().split("");

        System.out.println(asciiToString(revStrArr));
    }
}
