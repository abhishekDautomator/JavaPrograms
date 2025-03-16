import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class A{
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Abhishek");

        Employee emp2 = new Employee(2, "Raghu");

        Employee emp3 = new Employee(3, "Abhishek");

        List<Employee> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);

        Map<String, List<Employee>> nameList = empList.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println(nameList);
    }
}