package threadLocal;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        //Only one time we have to initiate the thread local & we can use it to set the value of each particular thread we want
        ThreadLocal<String> threadLocal =  new ThreadLocal<>();

        //set() get the current thread & set this value to its thread local variable
        threadLocal.set(Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("Thread name inside thread: " + threadLocal.get());
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //get() first ref of this thread & return value of thread local for this thread
        System.out.println("Thread name outside thread: " + threadLocal.get());
    }
}
