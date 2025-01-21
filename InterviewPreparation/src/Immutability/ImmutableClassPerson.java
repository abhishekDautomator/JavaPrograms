package Immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClassPerson {
    private final String name; //final fields
    private final int age;
    private final List<String> programmingLaungaugaes;


    public ImmutableClassPerson(String name, int age, List<String> programmingLaungaugaes) {
        this.name = name;
        this.age = age;
        this.programmingLaungaugaes = new ArrayList<>(programmingLaungaugaes);
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public List<String> getProgrammingLaungaugaes() {
        return Collections.unmodifiableList(programmingLaungaugaes);
    }
    //No setters
}
