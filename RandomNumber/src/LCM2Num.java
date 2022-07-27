import java.util.Scanner;

public class LCM2Num {
    public static void main(String[] args) {
        System.out.println("Enter 2 numbers");
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();

        int lcm = (a * b) / HCForGCD2Num.getGCD(a, b);

        System.out.println("LCM of the numbers " + a + " and " + b + " is " + lcm);
    }
}
