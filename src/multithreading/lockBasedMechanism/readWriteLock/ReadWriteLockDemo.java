package multithreading.lockBasedMechanism.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        SharedResource sharedResource = new SharedResource(readWriteLock);

        Thread t1 = new Thread(() -> {
            sharedResource.produce();
        });

        Thread t2 = new Thread(() -> {
            sharedResource.produce();
        });

        SharedResource sharedResource1 = new SharedResource(readWriteLock);
        Thread t3 = new Thread(() -> {
            sharedResource1.consume();
        });

        Thread t4 = new Thread(() -> {
            sharedResource1.consume();
        });


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
