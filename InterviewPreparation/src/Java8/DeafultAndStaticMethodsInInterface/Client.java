package Java8.DeafultAndStaticMethodsInInterface;

public class Client {
    public static void main(String[] args) {
        Java8Interface backendDev = new BackendDeveloper();
        Java8Interface webDev = new WebDeveloper();
        backendDev.newMethod();
        backendDev.init();
        webDev.newMethod();
        webDev.init();

        BackendDeveloper.destroy();
        Java8Interface.destroy();
    }
}
