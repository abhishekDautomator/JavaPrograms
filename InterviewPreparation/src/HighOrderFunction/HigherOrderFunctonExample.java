package HighOrderFunction;

public class HigherOrderFunctonExample {

    static int calcualte(int a, int b, OperateFunctionalInterface operateFunctionalInterface){
        return operateFunctionalInterface.operate(a, b);
    }

    public static void main(String[] args) {
        OperateFunctionalInterface calculateSum = Integer::sum;
        OperateFunctionalInterface calculateMultiply = (a,b) -> a*b;
        OperateFunctionalInterface calculateSubtraction = (a,b) -> a-b;

        System.out.println("Sum: "+calcualte(12, 23, calculateSum));
        System.out.println("Multiply: "+calcualte(12, 23, calculateMultiply));
        System.out.println("Subtraction: "+calcualte(12, 23, calculateSubtraction));
    }
}
