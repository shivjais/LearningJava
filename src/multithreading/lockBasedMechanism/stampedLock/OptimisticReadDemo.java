package multithreading.lockBasedMechanism.stampedLock;

import java.util.concurrent.locks.StampedLock;

public class OptimisticReadDemo {
    public static void main(String[] args) {
        StampedLock stampedLock = new StampedLock();
        SharedResourceWithOptimisticRead sharedResource = new SharedResourceWithOptimisticRead(stampedLock);

        Thread t1 = new Thread(()->sharedResource.producer());
        Thread t2 = new Thread(()->sharedResource.consumer());
        t1.start();
        t2.start();

    }
}
