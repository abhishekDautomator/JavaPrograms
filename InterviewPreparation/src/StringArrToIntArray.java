import java.util.Arrays;
import java.util.Scanner;

public class StringArrToIntArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int totalEle = scn.nextInt();
        int totalNegSum = 0;
        scn.nextLine();
        String line = scn.nextLine();
        int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<totalEle; i++){

            for(int j=i;j<totalEle;j++){
                int sum = 0;
                int k = j;
                while(k>=i){
                    sum+=arr[k];
                    k--;
                }
                System.out.println("Sum : "+sum);
                if(sum<0)
                    totalNegSum++;
            }
        }
        System.out.println(totalNegSum);
        scn.close();
    }
}
