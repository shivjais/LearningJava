package multithreading.lockBasedMechanism.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private boolean isAvailable = false;
    ReentrantLock lock;
    Condition condition;

    SharedResource(ReentrantLock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void produce(){
        try {
            lock.lock();
            System.out.println("Producer Lock is acquired by "+Thread.currentThread().getName());
            if(isAvailable){
                //already avaiable, producer thread has to wait for it to consume
                System.out.println("Producer Thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        }
        catch (InterruptedException e) {}
        finally {
            System.out.println("Producer Thread is released by "+Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void consume(){
        try {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consumer Lock is acquired by "+Thread.currentThread().getName());

            if(!isAvailable){
                //already not availbale, thread has to wait to produce
                System.out.println("Consumer Thread is waiting: "+Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        }
        catch (InterruptedException e) {}
        finally {
            System.out.println("Consumer Thread is released by "+Thread.currentThread().getName());
            lock.unlock();
        }

    }
}
