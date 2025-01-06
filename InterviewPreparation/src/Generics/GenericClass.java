package Generics;

public class GenericClass<T> { //Generic class

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public static <K> K getSomething(K k){ //generic method
        return k;
    }

    public static void main(String[] args) {
        GenericClass<String> genericClass = new GenericClass<>();
        genericClass.setItem("This is a return from the getter method of a generic class");
        System.out.println(genericClass.getItem());

        String returnVal = getSomething("This is a return from a generic method");
        System.out.println(returnVal);
    }
}
