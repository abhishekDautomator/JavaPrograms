package Java8.DeafultAndStaticMethodsInInterface;

public class BackendDeveloper implements Java8Interface{
    @Override
    public void newMethod() {
        System.out.println("I am a Backend developer");
    }
  /*
    @Override //cannot override destroy method as it's static
    public void destroy(){
        System.out.println("This is backend destroy method implementation");
    }*/

    static void destroy(){ //method over hiding
        System.out.println("This is backend destroy method implementation");
    }
}
