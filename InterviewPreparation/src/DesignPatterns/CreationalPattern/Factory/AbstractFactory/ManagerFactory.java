package DesignPatterns.CreationalPattern.Factory.AbstractFactory;

import DesignPatterns.CreationalPattern.Factory.Employee;
import DesignPatterns.CreationalPattern.Factory.Manager;

public class ManagerFactory extends EmployeeAbstractFactory{
    @Override
    public Employee createEmployee() {
        return new Manager();
    }
}
