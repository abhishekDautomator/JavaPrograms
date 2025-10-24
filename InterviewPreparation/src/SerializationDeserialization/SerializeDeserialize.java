package SerializationDeserialization;

import java.io.*;

class SerializeDeserializeImpl implements Serializable {

    public static void serializeString(String str) throws IOException {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("serialize.ser"); //will save the file in the current working directory
            oos = new ObjectOutputStream(fos);
            oos.writeObject(str);

            System.out.println("String is serialized in a file at the current working directory");
        }catch (FileNotFoundException fe){
            throw new RuntimeException(fe);
        }finally{
            assert oos != null;
            oos.close();
            fos.close();
        }
    }

    public static String deSerialize(){
        try{
            FileInputStream fis = new FileInputStream("serialize.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois.readObject().toString();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SerializeDeserialize{
    public static void main(String[] args) throws IOException {
        SerializeDeserializeImpl.serializeString("Hello Abhishek, how are you?");
        System.out.println(SerializeDeserializeImpl.deSerialize());
    }
}
