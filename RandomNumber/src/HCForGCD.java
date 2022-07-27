import java.util.Scanner;

public class HCForGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the 2 numbers of which GCD is required");
        int fNum = scanner.nextInt();
        int sNum = scanner.nextInt();
        System.out.println("GCD/HCF of the numbers " + fNum + " and " + sNum + " is " + HCForGCD.getGCD(fNum, sNum));
    }

    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }
}
