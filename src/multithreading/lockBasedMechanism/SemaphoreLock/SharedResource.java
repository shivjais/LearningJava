package multithreading.lockBasedMechanism.SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {
    Semaphore semaphore;
    boolean isAvailable = false;


    SharedResource(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void producer(){
        try {
            semaphore.acquire();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {}
        finally {
            System.out.println("Lock released by: " + Thread.currentThread().getName());
            semaphore.release();
        }
    }

}
