package Java8.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EmployeePredicate {
    String name;
    String designation;
    double salary;
    String city;

    public EmployeePredicate(String name, String designation, double salary, String city) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString() {
        return "EmployeePredicate{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class Test{
    public static void main(String[] args) {
        ArrayList<EmployeePredicate> list = new ArrayList<>();
        EmployeePredicate e1 = new EmployeePredicate("Abhishek","Senior Associate", 2500000,"Bangalore");
        EmployeePredicate e2 = new EmployeePredicate("Anu","QA Analyst", 1800000,"Bangalore");
        EmployeePredicate e3 = new EmployeePredicate("Narayan","Senior Developer", 2000000,"Pune");
        list.add(e1);
        list.add(e2);
        list.add(e3);
        Predicate<EmployeePredicate> predicateSalGrtThn20L = e -> e.getSalary()>=2000000.0;
        Predicate<EmployeePredicate> predicateBaseLocation = e -> e.getCity().equalsIgnoreCase("Bangalore");
        Predicate<EmployeePredicate> predicateIsEqual = Predicate.isEqual(null);
        System.out.println("Employee with salary greater than 20L");
        for (EmployeePredicate e:
             list) {
            if(predicateSalGrtThn20L.test(e))
                System.out.println(e);
        }
        System.out.println();
        System.out.println("Employee with base location as Bangalore");
        for (EmployeePredicate e:
                list) {
            if(predicateBaseLocation.test(e))
                System.out.println(e);
        }
        System.out.println();
        System.out.println("Employee with base location as not Bangalore and has salary greater than equal to 20L");
        for (EmployeePredicate e:
                list) {
            if(predicateBaseLocation.negate().and(predicateSalGrtThn20L).test(e))
                System.out.println(e);
        }
        System.out.println();
        System.out.println("Non null Employee");
        for (EmployeePredicate e:
                list) {
            if(predicateIsEqual.negate().test(e))
                System.out.println(e);
        }
    }
}
