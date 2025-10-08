package DesignPatterns.CreationalPattern.Singleton;

import java.io.Serial;
import java.io.Serializable;

public class SingletonObjCreationInBestWay implements Cloneable, Serializable {

    private SingletonObjCreationInBestWay(){
        //To prevent singleton break using Reflection API
        throw new RuntimeException("You are trying to break singleton obj");
    }

    private static class SingletonHelper{
        private static final SingletonObjCreationInBestWay obj = new SingletonObjCreationInBestWay();
    }

    public static SingletonObjCreationInBestWay getObj(){
        return SingletonHelper.obj;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cannot clone singleton instance");
    }

    @Serial
    private Object readResolve() {
        return getObj();
    }
}
