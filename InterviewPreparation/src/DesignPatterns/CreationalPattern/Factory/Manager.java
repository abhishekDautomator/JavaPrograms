package DesignPatterns.CreationalPattern.Factory;

public class Manager implements Employee{
    @Override
    public int salary() {
        System.out.println("I am a manager");
        return 80000;
    }
}
