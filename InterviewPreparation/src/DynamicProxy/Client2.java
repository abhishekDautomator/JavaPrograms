package DynamicProxy;

import java.lang.reflect.Proxy;

public class Client2 {
    public static void main(String[] args) {
        Example2Interface obj = new Example2Interface() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello, "+name+"!");
            }
        };

        Example2Interface proxy = (Example2Interface) Proxy.newProxyInstance(
                Example2.class.getClassLoader(),
                new Class[]{Example2.class},
                new Example2(obj)
        );

        proxy.sayHello("Abhishek");
    }
}
