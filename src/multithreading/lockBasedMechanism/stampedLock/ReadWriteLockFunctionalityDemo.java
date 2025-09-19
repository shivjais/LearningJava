package multithreading.lockBasedMechanism.stampedLock;

import java.util.concurrent.locks.StampedLock;

public class ReadWriteLockFunctionalityDemo {
    public static void main(String[] args) {
        StampedLock stampedLock = new StampedLock();
        SharedResourceWithReadWrite sharedResource = new SharedResourceWithReadWrite(stampedLock);

        Thread t1 = new Thread(()->sharedResource.producer());
        Thread t2 = new Thread(()->sharedResource.producer());
        Thread t3 = new Thread(()->sharedResource.consumer());
        Thread t4 = new Thread(()->sharedResource.consumer());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
