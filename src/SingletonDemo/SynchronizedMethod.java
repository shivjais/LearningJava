package SingletonDemo;

//This approach will work in multi threaded environment
//but it will be too slow because we are using synchronised at method level
public class SynchronizedMethod {
    private static SynchronizedMethod instance;

    private SynchronizedMethod() {}

    //create instance only for the first time only
    public synchronized static SynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SynchronizedMethod();
        }
        return instance;
    }
}
