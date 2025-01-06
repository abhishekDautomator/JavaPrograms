package DesignPatterns.CreationalPattern.Factory;

import DesignPatterns.CreationalPattern.AbstractFactory.BackendDeveloperFactory;
import DesignPatterns.CreationalPattern.AbstractFactory.EmployeeAbstractFactory;
import DesignPatterns.CreationalPattern.AbstractFactory.ManagerFactory;
import DesignPatterns.CreationalPattern.AbstractFactory.WebDeveloperFactory;

public class ClientClass {
    public static void main(String[] args) {
        Employee emp1 = EmployeeFactoryClass.getEmployeeSalary("Web");
        System.out.println("My salary is: "+emp1.salary());
        Employee emp2 = EmployeeFactoryClass.getEmployeeSalary("backend");
        System.out.println("My salary is: "+emp2.salary());

        //using abstract factory class
        System.out.println("Using abstract factory class approach now");
        Employee emp3 = EmployeeFactoryClass.getEmployeeSalary(new BackendDeveloperFactory());
        System.out.println("My salary is: "+emp3.salary());
        Employee emp4 = EmployeeFactoryClass.getEmployeeSalary(new WebDeveloperFactory());
        System.out.println("My salary is: "+emp4.salary());
        Employee emp5 = EmployeeFactoryClass.getEmployeeSalary(new ManagerFactory());
        System.out.println("My salary is: "+emp5.salary());
    }
}
