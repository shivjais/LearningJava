package interfaceDemo;

//interface can be public & default
public interface Bird {

    //By Default, all variables in interface are public static final
    public static final int MAX_HEIGHT = 1000;

    //By default, interface methods are public & abstract
    //interface methods can't be final
    public abstract void canFly();

    //providing default impl & this method need not implement by all implemented concreate class
    public default void fly(){

    }

    default void canRun(){

    }

    default void canEat(){}

    //static methods introduced in java 8
    public static boolean canBreathe(){
        return true;
    }

    //private method & private static methods are introduced in java 9
    //these methods can be accessed by default & static method
    private void myPrivateMethod(){}
    private static void myPrivateStaticMethod(){}
}
