package Interface;

class BackendDeveloper implements Java8Interface{
    @Override
    public void develop() {
        System.out.println("Providing implementation of the interface abstract method");
    }

    public void callingInterfaceMethod(){
        Java8Interface.deploy();
    }
}

class Calculator implements FunctionalInterfaceClass{
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}

public class Main{
    public static void main(String[] args) {
        BackendDeveloper backendDeveloper = new BackendDeveloper();
        backendDeveloper.develop();
        backendDeveloper.test();
        backendDeveloper.callingInterfaceMethod();

        Calculator calc = new Calculator();
        System.out.println("sum of 107 and 456 is "+calc.add(107, 456));
        System.out.println("multiplication of 431 and 906 is "+calc.multiply(431, 906));

        //Implementing FunctionalInterface using lambda expression
        FunctionalInterfaceClass add = Integer::sum;
    }
}

