package multithreading.lockBasedMechanism.stampedLock;

import java.util.concurrent.locks.StampedLock;

//Stamped lock provide the Read/write lock functionality like readWriteLock & also optimistic read functionality
//Here we are showing optimistic read functionality using stamp lock
public class SharedResourceWithOptimisticRead {
    private StampedLock stampedLock;
    private int a = 10;

    public SharedResourceWithOptimisticRead(StampedLock stampedLock) {
        this.stampedLock = stampedLock;
    }

    public void producer(){
        // this stamp is used to pass which unlocking & its a snapshot of data which we are trying to update
        // this is used to validate existing data is updated or not
        long stamp = stampedLock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic read by: " + Thread.currentThread().getName());
            a = 11;
            Thread.sleep(6000);
            //validate is there is any write operation on value a. if no update the value otherwise rollback its value
            if(stampedLock.validate(stamp)){
                System.out.println("Update successfully");
            }else {
                System.out.println("Rollback Updated value");
                a = 10;
            }
        }
        catch (InterruptedException e){}
    }

    public void consumer(){
        long stamp = stampedLock.writeLock();
        try{
            System.out.println("Write lock is acquired by: " + Thread.currentThread().getName());
            a = 9;
        }
        finally {
            System.out.println("Write lock is released by: " + Thread.currentThread().getName());
            stampedLock.unlock(stamp);

        }
    }
}
