package DesignPatterns.CreationalPattern.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonClassBreakUsingReflection {
    //Using Reflection API to break Singleton
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        SingletonObjCreationInBestWay obj = SingletonObjCreationInBestWay.getObj();
        System.out.println("Object 1: "+obj.hashCode());

        Constructor<?> constructor = SingletonObjCreationInBestWay.class.getDeclaredConstructor();
        constructor.setAccessible(true); // Make the private constructor accessible

        // Create another instance using reflection
        SingletonObjCreationInBestWay obj2 = (SingletonObjCreationInBestWay) constructor.newInstance();
        System.out.println("Object 2: " + obj2.hashCode());

        SingletonBreakUsingReflectionPreventionEnum ob = SingletonBreakUsingReflectionPreventionEnum.INSTANCE;
        System.out.println("Object 3: "+ob.hashCode());
        Constructor<?> constructor2 = SingletonBreakUsingReflectionPreventionEnum.class.getDeclaredConstructor();
        constructor2.setAccessible(true); // Make the private constructor accessible

        // Create another instance using reflection
        SingletonBreakUsingReflectionPreventionEnum obj4 = (SingletonBreakUsingReflectionPreventionEnum) constructor2.newInstance();
        System.out.println("Object 4: " + obj4.hashCode());

    }

}
