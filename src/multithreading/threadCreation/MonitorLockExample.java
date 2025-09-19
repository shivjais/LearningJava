package multithreading.threadCreation;

//Monitor lock helps to make sure that only 1 thread goes inside a particular section of code
public class MonitorLockExample {

    public synchronized void task1(){
        try {
            System.out.println("inside task1");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){
        System.out.println("inside task2, but before synchronised");
        synchronized (this) {
            System.out.println("inside task2, inside synchronised");
        }
    }
    public void task3(){
        System.out.println("inside task3");
    }
}
