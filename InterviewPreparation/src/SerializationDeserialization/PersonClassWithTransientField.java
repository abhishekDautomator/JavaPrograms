package SerializationDeserialization;

import java.io.Serial;
import java.io.Serializable;

public class PersonClassWithTransientField implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String name;
    private final transient int age;

    public PersonClassWithTransientField(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}
