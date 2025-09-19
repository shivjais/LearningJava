package multithreading.lockBasedMechanism.reentrentLock;

import java.util.concurrent.locks.ReentrantLock;

//if we use reentrant lock, there is no need of synchronised
//we use this lock when we allowed only one thread in our critical section irrespective of object in which it is called
public class SharedResource {
    private ReentrantLock lock;
    private boolean isAvailable;

    SharedResource(ReentrantLock lock) {
        this.lock = lock;
        this.isAvailable = false;
    }

    public void produce(){

        try {
            lock.lock();
            System.out.println("Lock is acquired by "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            System.out.println("Lock is released by "+Thread.currentThread().getName());
        }

    }
}
