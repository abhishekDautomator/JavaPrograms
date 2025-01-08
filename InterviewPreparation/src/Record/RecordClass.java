package Record;

record RecordClassImpl(String name, int age) {

    RecordClassImpl(String name){ //self-made constructor can also be formed
        this(name, 20);
    }

    public void displayName(String name){ //instance method can also be created
        System.out.println("Displaying name: "+name);
    }

    public static void displayAge(int age){ //static method can also be formed inside record
        System.out.println("Displaying age: "+age);
    }
}

public class RecordClass{
    public static void main(String[] args) {
        RecordClassImpl person = new RecordClassImpl("Alice", 28);

        System.out.println(person.name()); // Accessor for 'name'
        System.out.println(person.age());  // Accessor for 'age'
        System.out.println(person); // toString()

        RecordClassImpl person2 = new RecordClassImpl("Abhishek");
        System.out.println(person2);
        person2.displayName("Narayan");
        RecordClassImpl.displayAge(30);
    }
}
