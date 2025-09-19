package multithreading.lockBasedMechanism.synchronised;

public class ConsumerTask implements Runnable{
    private SharedResource sharedResource;

    public  ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Consumer Thread Start: "+Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
