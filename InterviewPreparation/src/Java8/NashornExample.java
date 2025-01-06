package Java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornExample {
    //Nashorn is a JavaScript engine bundled with Java 8 that allows developers to execute JavaScript code within Java applications. It supports running scripts and integrating JavaScript functionalities seamlessly
    public static void main(String[] args) throws Exception {
        // Create a Script Engine Manager
        ScriptEngineManager manager = new ScriptEngineManager();
        // Get the Nashorn engine
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // Execute a JavaScript code snippet
        engine.eval("print('Hello from Nashorn')");

        // Explanation:
        // 1. ScriptEngineManager is used to manage scripting engines.
        // 2. `eval` executes dynamic JavaScript code within Java.
    }
}