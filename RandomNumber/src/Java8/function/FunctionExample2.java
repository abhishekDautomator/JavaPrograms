package Java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample2 {
    public static void main(String[] args) {
        ArrayList<Employee> l  = new ArrayList<>();
        l.add(new Employee("Abhishek",140000.0));
        l.add(new Employee("Anu",110000));
        l.add(new Employee("Narayan",50000.0));
        l.add(new Employee("Sah",20000.0));

        Function<ArrayList<Employee>, Integer> sumSal = list -> {
            int sum = 0;
            for (Employee e:
                    list) {
                sum+=e.getSalary();
            }
            return sum;
        };

        System.out.println("Total monthly salary of all employee : "+sumSal.apply(l));

        System.out.println("Incrementing salary of employee");
        int bonus = 50000;
        Function<Employee, Employee> increasingSalary = e -> {e.setSalary(e.getSalary()+bonus); return e;};

        for (Employee e:
             l) {
            increasingSalary.apply(e);
        }

        System.out.println(l);
    }
}

class Employee
{
    String name;
    double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}