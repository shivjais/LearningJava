package functionalInterface;

@FunctionalInterface
public interface User {
    String getName();

    default void age(){}

    static void eat(){}

    //We can add any number of object class method inside the functional interface
    //because they are by default present in any class/interface
    String toString();
    int hashCode();
    boolean equals(Object object);
}
