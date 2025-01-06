package DesignPatterns.CreationalPattern.Factory;

public class BackendDeveloper implements Employee{
    @Override
    public int salary() {
        System.out.println("My role is backend development");
        return 50000;
    }
}
