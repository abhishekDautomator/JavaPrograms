package DynamicProxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Map<String, Integer> fees = (Map<String, Integer>) Proxy.newProxyInstance(
                HashMap.class.getClassLoader(), new Class[]{Map.class}, new ObjectHandler(new HashMap<>())
        );/*new HashMap();*/
        fees.put("java", 4000);
        System.out.println(fees);
    }
}
