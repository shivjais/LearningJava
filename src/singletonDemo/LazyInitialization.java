package singletonDemo;

//This approach will fail for multithreaded in environment
//this will create two diff objects
public class LazyInitialization {
    private static LazyInitialization instance;

    private LazyInitialization() {}

    //create instance only for the first time only
    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
