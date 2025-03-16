package Immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClassPerson {
    private final String name; //final fields
    private final int age;
    private final List<String> programmingLanguages;
    private final Department department;

    public ImmutableClassPerson(String name, int age, List<String> programmingLanguages, Department department) {
        this.name = name;
        this.age = age;
        this.programmingLanguages = new ArrayList<>(programmingLanguages);
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }
}


