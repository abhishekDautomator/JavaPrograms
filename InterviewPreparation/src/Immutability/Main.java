package Immutability;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> pl = new ArrayList<String>();
        pl.add("java");
        pl.add("python");
        ImmutableClassPerson immutableClassPerson = new ImmutableClassPerson("Abhishek", 30, pl, new Department(1, "DEDX"));
        System.out.println("name: "+immutableClassPerson.getName()+" | age: "+immutableClassPerson.getAge()+" | PL: "+immutableClassPerson.getProgrammingLanguages());
        pl.add("node");
        System.out.println("PL: "+immutableClassPerson.getProgrammingLanguages());
    }
}
