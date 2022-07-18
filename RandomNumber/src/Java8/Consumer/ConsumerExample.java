package Java8.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Employee e1 = new Employee("Abhishek",1,140000,"Senior Associate");
        Employee e2 = new Employee("Anu",1,110000,"Senior QA");
        List<Employee> l = new ArrayList<>();
        l.add(e1);
        l.add(e2);
        Consumer<Employee> consume = e -> {
            System.out.println("Name : "+e.getName()+" | Salary : "+e.getSalary()+" | designation : "+e.getDesignation());
        };

        for (Employee e:
             l) {
            consume.accept(e);
        }
    }
}

class Employee{
    String name;
    int id;
    int salary;
    String designation;

    public Employee(String name, int id, int salary, String designation) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                '}';
    }
}
