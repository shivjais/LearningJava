package multithreading.threadCreation;

public class UsingRunnable {

    public static void main(String[] args) {
        System.out.println("Thread Name: " + Thread.currentThread().getName());

        //By implementing runnable interface
        Thread runnableThread = new Thread(new RunnableImpl());
        runnableThread.start();

        //By extending thread class
        ThreadImpl thread = new ThreadImpl();
        thread.start();

        //Monitor lock demo
        MonitorLockExample monitorLock = new MonitorLockExample();
        Thread t1 = new Thread(()->monitorLock.task1());
        Thread t2 = new Thread(()->monitorLock.task2());
        Thread t3 = new Thread(()->monitorLock.task3());
        t1.start();
        t2.start();
        t3.start();
    }
}
