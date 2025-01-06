package Java8.DeafultAndStaticMethodsInInterface;

public interface Java8Interface {
    void newMethod();
    default void init(){
        System.out.println("This is a default initialization");
    }
    static void destroy(){ //static method can't be overridden
        System.out.println("This is a static method");
    }
}
