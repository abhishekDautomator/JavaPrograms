package Interface;

public interface Java8Interface {

    void develop(); //public abstract by default

    default void test(){
        System.out.println(" Default method implementation in interface");
    }

    static void deploy(){
        System.out.println(" static method implementation in interface");
    }
}
