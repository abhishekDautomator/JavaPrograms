package DesignPatterns.CreationalPattern.Singleton;

import java.io.*;

public class SingletonclassbreakusingDesirialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingletonClass2 obj = SingletonClass2.getSingletonObj2();
        System.out.println(obj.hashCode());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.ob"));
        oos.writeObject(obj);

        System.out.println("Serializing the object");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.ob"));
        System.out.println("De-serializing the serialized object");
        SingletonClass2 objDeserialized = (SingletonClass2) ois.readObject();
        System.out.println(objDeserialized.hashCode());
        //how to prevent from singleton break using de-serialization
    }


}
