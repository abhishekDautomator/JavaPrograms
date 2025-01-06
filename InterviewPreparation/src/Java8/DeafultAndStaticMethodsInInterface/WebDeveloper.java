package Java8.DeafultAndStaticMethodsInInterface;

public class WebDeveloper implements Java8Interface{
    @Override
    public void newMethod() {
        System.out.println("I am a Web Developer");
    }

    @Override
    public void init(){ //overriding default method initialization
        System.out.println("This is web developer specific initialization");
    }
}
