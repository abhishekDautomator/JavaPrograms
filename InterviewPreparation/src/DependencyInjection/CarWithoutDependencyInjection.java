package DependencyInjection;

public class CarWithoutDependencyInjection {
    private final Engine engine;

    public CarWithoutDependencyInjection() {
        this.engine = new Engine(); //tight coupling
    }

    public void drive(){
        engine.start();
        System.out.println("Car is running");
    }
}

class Engine {
    public void start() {
        System.out.println("Engine starting...");
    }
}