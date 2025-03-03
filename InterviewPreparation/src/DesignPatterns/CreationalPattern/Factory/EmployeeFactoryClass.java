package DesignPatterns.CreationalPattern.Factory;

import DesignPatterns.CreationalPattern.Factory.AbstractFactory.EmployeeAbstractFactory;

public class EmployeeFactoryClass {

    public static Employee getEmployeeSalary(String empType){
        if(empType.trim().equalsIgnoreCase("web")){
            return new WebDeveloper();
        } else if (empType.trim().equalsIgnoreCase("backend")) {
            return new BackendDeveloper();
        }else throw new RuntimeException("No such employee type exists");
    }

    public static Employee getEmployeeSalary(EmployeeAbstractFactory employeeAbstractFactory){
        return employeeAbstractFactory.createEmployee();
    }
}
