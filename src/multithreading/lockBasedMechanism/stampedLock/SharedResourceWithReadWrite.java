package multithreading.lockBasedMechanism.stampedLock;

import java.util.concurrent.locks.StampedLock;

//Stamped lock provide the Read/write lock functionality like readWriteLock & also optimistic read functionality
//Here we are showing Read/write lock functionality using stamp lock
public class SharedResourceWithReadWrite {
    private StampedLock stampedLock;

    public SharedResourceWithReadWrite(StampedLock stampedLock) {
        this.stampedLock = stampedLock;
    }

    public void producer(){
        //this stamp is used to pass which unlocking & its a snapshot of data which we are trying to update
        // but this is more used in optimistic reads
        long stamp = stampedLock.readLock();
        try{

            System.out.println("Read lock is acquired by: " + Thread.currentThread().getName());
            Thread.sleep(6000);
        }
        catch (InterruptedException e){}
        finally {
            System.out.println("Read lock is released by: " + Thread.currentThread().getName());
            stampedLock.unlock(stamp);

        }
    }

    public void consumer(){
        long stamp = stampedLock.writeLock();
        try{
            System.out.println("Write lock is acquired by: " + Thread.currentThread().getName());
        }
        finally {
            System.out.println("Write lock is released by: " + Thread.currentThread().getName());
            stampedLock.unlock(stamp);

        }
    }
}
