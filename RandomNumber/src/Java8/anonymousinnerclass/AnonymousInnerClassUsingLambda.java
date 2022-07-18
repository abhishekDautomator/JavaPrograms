package Java8.anonymousinnerclass;

public class AnonymousInnerClassUsingLambda {
    public static void main(String[] args) {
        Thread t = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Runnable thread " + i);
                    }
                }
        );
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread " + i);
        }
    }
}
