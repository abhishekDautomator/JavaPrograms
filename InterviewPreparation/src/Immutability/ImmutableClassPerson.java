package Immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClassPerson {
    private final String name; //final fields
    private final int age;
    private final List<String> programmingLanguages;


    public ImmutableClassPerson(String name, int age, List<String> programmingLanguages) {
        this.name = name;
        this.age = age;
        this.programmingLanguages = new ArrayList<>(programmingLanguages); //new copy of programmingLanguages
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public List<String> getProgrammingLanguages() {
        return Collections.unmodifiableList(programmingLanguages);
    }
    //No setters
}
