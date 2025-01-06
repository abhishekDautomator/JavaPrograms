package DesignPatterns.BehavioralPattern.ObserverDesign;

public class Subscriber implements Observer{

    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notified(String title) {
        System.out.println("Hi "+name+", a new video having title "+title+" has been uploaded in our channel");
    }

    @Override
    public String name() {
        return this.name;
    }
}
