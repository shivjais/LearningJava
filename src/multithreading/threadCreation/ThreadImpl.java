package multithreading.threadCreation;

public class ThreadImpl extends Thread {
    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }
}
