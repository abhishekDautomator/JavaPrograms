package DesignPatterns.CreationalPattern.Singleton;

class SingletonClass {
    //Singleton class: Any class for which can have only one object are called as singleton class.
    //Ex: RunTime, BusinessDelegate, ServiceLocator
    //Share same object with all the calls. This will improve performance and very less memory required.
    // Re-use the same object for every similar requirement
    //Advantage: Memory utilization improvement, re-usability, improve performance

    private static final SingletonClass singletonObj = new SingletonClass(); //Eager way of object creation
    //private so that it's value can't be changed outside
    //Obj create during the first time and return the same object in the consecutive calls.

    private SingletonClass(){ }//child class cannot be created.
                                // Object cannot be created using private constructor

    public static  SingletonClass getSingleTonObj(){ //static method is used so that no object creation is required
        return singletonObj;
    }

}
