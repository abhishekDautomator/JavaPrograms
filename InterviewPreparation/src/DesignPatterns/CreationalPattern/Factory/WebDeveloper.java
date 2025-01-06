package DesignPatterns.CreationalPattern.Factory;

public class WebDeveloper implements Employee{
    @Override
    public int salary() {
        System.out.println("My role is Web Developer");
        return 45000;
    }
}
