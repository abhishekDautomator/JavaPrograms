package DependencyInjection;

public class CarWithDependencyInjection {
    private final EngineInterface engine;

    // Constructor injection
    public CarWithDependencyInjection(EngineInterface engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }

    public static void main(String[] args) {
        EngineInterface engine = new V8Engine(); // Create the dependency
        CarWithDependencyInjection car = new CarWithDependencyInjection(engine); // Inject the dependency
        car.drive();
    }
}
