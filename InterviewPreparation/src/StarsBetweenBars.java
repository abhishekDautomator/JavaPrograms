import java.util.Scanner;

public class StarsBetweenBars {

    public static String getSubStringBasedOnIndices(String str, int start, int end){
        start = Math.max(0, start - 1);
        end = Math.min(str.length(), end);
        return str.substring(start, end);
    }

    public static int findStarsBetweenBars2(String str) { //easy way
        int starCount = 0;
        int firstPipeIndex = str.indexOf('|');
        int lastPipeIndex= str.lastIndexOf('|');
        for(int i=firstPipeIndex+1;i<lastPipeIndex;i++){
            if(str.charAt(i)=='*')
                starCount++;
        }
        return starCount;
    }

    public static int findStarsBetweenBars(String str) { //hard way
        int starCount = 0;
        int firstPipeIndex = -1;
        int secondPipeIndex;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '|') {
                if (firstPipeIndex == -1) {
                    firstPipeIndex = i;
                } else {
                    secondPipeIndex = i;
                    // Count stars between the two pipes
                    for (int j = firstPipeIndex + 1; j < secondPipeIndex; j++) {
                        if (str.charAt(j) == '*') {
                            starCount++;
                        }
                    }
                    // Move the first pipe index to the second pipe index for the next pair
                    firstPipeIndex = i;
                }
            }
        }
        return starCount;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next(); //|**|*|
        int n=sc.nextInt();

        int startIndex[]=new int[n];
        int endIndex[]=new int[n];

        for(int i=0;i<n;i++)
            startIndex[i]=sc.nextInt();

        for(int i=0;i<n;i++)
            endIndex[i]=sc.nextInt();

        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i] = findStarsBetweenBars2(getSubStringBasedOnIndices(str, startIndex[i], endIndex[i]));
        }

        for(int i=0;i<n;i++){
            System.out.println(result[i]);
        }
    }
}
