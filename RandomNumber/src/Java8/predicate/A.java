package Java8.predicate;

public interface A {
    int method1(String s);
}

class B {
    public static void main(String[] args) {
        A t = (s) -> Integer.parseInt("2");
    }
}
