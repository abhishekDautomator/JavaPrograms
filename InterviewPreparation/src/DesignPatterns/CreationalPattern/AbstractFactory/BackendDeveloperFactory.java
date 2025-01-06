package DesignPatterns.CreationalPattern.AbstractFactory;

import DesignPatterns.CreationalPattern.Factory.BackendDeveloper;
import DesignPatterns.CreationalPattern.Factory.Employee;

public class BackendDeveloperFactory extends EmployeeAbstractFactory{
    @Override
    public Employee createEmployee() {
        return new BackendDeveloper();
    }
}
