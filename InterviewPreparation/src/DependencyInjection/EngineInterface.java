package DependencyInjection;

public interface EngineInterface {
    void start();
}

class V8Engine implements EngineInterface {
    @Override
    public void start() {
        System.out.println("V8 Engine starting...");
    }
}


