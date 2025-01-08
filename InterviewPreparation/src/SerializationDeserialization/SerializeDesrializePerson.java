package SerializationDeserialization;

import java.io.*;

public class SerializeDesrializePerson {
    public static void main(String[] args) {
        PersonClassWithTransientField person = new PersonClassWithTransientField("Alice", 28);

        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Unserialized Person: " + person);
            System.out.println("Serialized data with transient field age is saved in person.ser");

            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            person = (PersonClassWithTransientField) in.readObject();
            System.out.println("Deserialized Person: " + person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
