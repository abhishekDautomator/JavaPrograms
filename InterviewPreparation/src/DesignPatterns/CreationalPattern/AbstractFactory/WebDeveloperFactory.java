package DesignPatterns.CreationalPattern.AbstractFactory;

import DesignPatterns.CreationalPattern.Factory.Employee;
import DesignPatterns.CreationalPattern.Factory.WebDeveloper;

public class WebDeveloperFactory extends EmployeeAbstractFactory {
    @Override
    public Employee createEmployee() {
        return new WebDeveloper();
    }
}
