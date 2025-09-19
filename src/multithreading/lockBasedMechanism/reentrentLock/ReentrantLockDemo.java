package multithreading.lockBasedMechanism.reentrentLock;

import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SharedResource sharedResource = new SharedResource(lock);

        Thread thread1 = new Thread(sharedResource::produce);
        Thread thread2 = new Thread(()-> sharedResource.produce());

        thread1.start();
        thread2.start();
    }
}
