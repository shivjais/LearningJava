package multithreading.lockBasedMechanism.SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //only two threads are allowed in critical section at a time
        Semaphore semaphore = new Semaphore(2);
        SharedResource sharedResource = new SharedResource(semaphore);

        Thread t1 = new Thread(()->sharedResource.producer());
        Thread t2 = new Thread(()->sharedResource.producer());
        Thread t3 = new Thread(()->sharedResource.producer());
        Thread t4 = new Thread(()->sharedResource.producer());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
