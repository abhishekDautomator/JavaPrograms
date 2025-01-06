package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Example2 implements InvocationHandler {
    private Example2Interface obj;

    public Example2(Example2Interface obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //logic to modify behavior of method before invocation
        System.out.println("Before invoking method: "+method.getName());
        Object result = method.invoke(obj, args);
        System.out.println("after invoking method: "+method.getName());
        return result;
    }
}
