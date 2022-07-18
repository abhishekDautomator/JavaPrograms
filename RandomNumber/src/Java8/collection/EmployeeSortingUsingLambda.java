package Java8.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSortingUsingLambda {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Abhishek"));
        list.add(new Employee(2, "Narayan"));
        list.add(new Employee(3, "Bittu"));
        list.add(new Employee(4, "Anu"));
        Collections.sort(list,(e1, e2)->e1.getId()>e2.getId()?-1:e1.getId()<e2.getId()?1:0);
        System.out.println(list);
        Collections.sort(list,(e1, e2)->e1.getName().compareTo(e2.getName())>0?-1:e1.getName().compareTo(e2.getName())<0?1:0);
        System.out.println(list);
    }
}

class Employee{
    int id;
    String name;
    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
