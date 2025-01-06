package Java8;

public interface FunctionalInterface {
    public void m1();
}

interface FucntionalInterface2{
    public int add(int a, int b);
}

class Test{
    public static void main(String[] args) {
        FunctionalInterface i = () -> System.out.println("Example 1 of functional interface");
        i.m1();

        FucntionalInterface2 i2 = Integer::sum;
        System.out.println("Example 2 addition - "+i2.add(2,3));

        Runnable r = () -> {
            for (int j = 0; j < 10; j++) {
                System.out.println("Runnable thread "+(j+1));
            }
        };
        Thread t = new Thread(r);
        t.start();
        for (int j = 0; j < 10; j++) {
            System.out.println("Main thread "+(j+1));
        }
    }
}