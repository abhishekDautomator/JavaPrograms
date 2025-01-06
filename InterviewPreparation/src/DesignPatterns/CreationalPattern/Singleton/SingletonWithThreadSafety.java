package DesignPatterns.CreationalPattern.Singleton;

public class SingletonWithThreadSafety {

    private static SingletonWithThreadSafety obj = null;

    private SingletonWithThreadSafety(){

    }

    public static SingletonWithThreadSafety getObj(){
        if(obj==null){
            //Potential for Null Reference: The double-checked locking pattern
            // can lead to issues in certain Java memory models prior to Java 5,
            // where the constructor could be called before the reference is assigned,
            // resulting in a partially constructed object being returned.
            synchronized (SingletonWithThreadSafety.class) {
                if(obj==null){
                obj = new SingletonWithThreadSafety();
                }
            }
        }
        return obj;
    }
}
