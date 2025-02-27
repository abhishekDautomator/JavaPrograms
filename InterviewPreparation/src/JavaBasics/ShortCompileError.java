package JavaBasics;

public class ShortCompileError {
    public static void main(String[] args) {
        short x = 10;
        x = (short)(x * 5); //When performing an operation with a short value with a integer value,
        // Java will automatically promote
        // them to int type during the operation. Therefore, you should store the result in an
        // int or explicitly cast it back to short if needed.
        System.out.println(x);
    }
}
