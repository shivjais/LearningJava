package multithreading.lockBasedMechanism.readWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

//if we use ReadWriteLock, there is no need of synchronised
//we use this lock when we allowed only more than one thread in critical section
//and number of reads are higher than write
//In Read lock more than one thread can acquire read lock (Shared Lock)
//In Write lock only one thread can acquire write lock (Exclusive Lock)
public class SharedResource {
    private ReadWriteLock readWriteLock;
    private boolean isAvailable;

    SharedResource(ReadWriteLock lock) {
        this.readWriteLock = lock;
        this.isAvailable = false;
    }

    public void produce(){
        try {
            readWriteLock.readLock().lock();
            System.out.println("Read Lock is acquired by "+Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Read Lock is released by "+Thread.currentThread().getName());
            readWriteLock.readLock().unlock();
        }
    }

    public void consume(){
        try {
            readWriteLock.writeLock().lock();
            System.out.println("Write Lock is acquired by "+Thread.currentThread().getName());
            isAvailable = false;
            //Thread.sleep(4000);
        }
        catch (Exception e) {}
        finally {
            System.out.println("Write Lock is released by: "+Thread.currentThread().getName());
            readWriteLock.writeLock().unlock();

        }
    }
}
