package singletonDemo;

//This is also a bit slow due to locking mechanism in multithreaded environment
public class DoubleCheckLocking {
    //Due to volatile, threads will perform read/write directly from memory
    private static volatile DoubleCheckLocking instance;

    private DoubleCheckLocking() {}

    public static DoubleCheckLocking getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckLocking();
                }
            }
        }
        return instance;
    }
}
