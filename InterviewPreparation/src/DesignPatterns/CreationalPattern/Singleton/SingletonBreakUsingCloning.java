package DesignPatterns.CreationalPattern.Singleton;

public class SingletonBreakUsingCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonClass2 obj = SingletonClass2.getSingletonObj2();
        System.out.println(obj.hashCode());


        SingletonClass2 cloneObj = (SingletonClass2) obj.clone();
        System.out.println(cloneObj.hashCode());
    }
}
