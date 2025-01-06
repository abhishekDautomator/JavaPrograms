package DesignPatterns.CreationalPattern.Singleton;

import java.io.Serial;
import java.io.Serializable;

class SingletonClass2 implements Serializable, Cloneable { //implementing serializable for break using deserialization example class

    private static SingletonClass2 singletonObj2 = null;
    private SingletonClass2(){}
    public static SingletonClass2 getSingletonObj2(){
        if(singletonObj2==null){ //Lazy Initialization
            singletonObj2 = new SingletonClass2();
        }
        return singletonObj2;
    }

    //To prevent from singleton object break using de-serialization
    @Serial
    public Object readResolve(){
        return singletonObj2;
    }

    //To protect from Singleton break using cloning symptom
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return singletonObj2;
    }
}
