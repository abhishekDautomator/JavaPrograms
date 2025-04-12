public class SquareRootUsing4BasicMathOperands {
    public static void main(String[] args) {
        System.out.println("Square root of 16 is- "+squareRoot(16));
        System.out.println("Square root of 10 is- "+squareRoot(10));
    }

    static int squareRoot(int num){
        int t;
        int sqrtroot=num/2;
        do{
            t=sqrtroot;
            sqrtroot=(t+(num/t))/2; //Newton-Raphson method
        }while((t-sqrtroot)!= 0);
        return sqrtroot;
    }
}


