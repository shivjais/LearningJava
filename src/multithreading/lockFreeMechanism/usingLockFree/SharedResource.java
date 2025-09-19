package multithreading.lockFreeMechanism.usingLockFree;

import java.util.concurrent.atomic.AtomicInteger;

/** we can also use synchronised, but it will be lock based mechanism & it is also slow as compared to lock free mechanism.
 * Lock free mechanism uses compare & swap (CAS) technique*/
public class SharedResource {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }

    public int getCounter(){
        return counter.get();
    }
}
