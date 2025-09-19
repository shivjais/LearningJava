package multithreading.lockBasedMechanism.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/** When we were using synchronised it uses monitor lock & for inter-thread communication we used wait(), notify() & notifyAll()
 * but when we are using other lock mechanism we can't use these methods for inter thread communication because they are not using
 * monitor lock. For these type of lock we will use await(), signal() & signalAll()**/
public class ConditionDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        SharedResource sharedResource = new SharedResource(lock,condition);

        Thread t1 = new Thread(()->{
            for(int i=0;i<2;i++)
                sharedResource.produce();
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<2;i++)
                sharedResource.consume();
        });
        t1.start();
        t2.start();
    }

}
