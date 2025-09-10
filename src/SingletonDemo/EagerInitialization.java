package SingletonDemo;

//In this approach we are creating the object irrespective of whether we need it or not
public class EagerInitialization {
    //Eagerly create instance of this class
    //object is created at the time of class loading
    private static EagerInitialization instance = new EagerInitialization();

    private EagerInitialization() {}

    public static EagerInitialization getInstance() {
        return instance;
    }
}
