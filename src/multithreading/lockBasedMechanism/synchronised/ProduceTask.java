package multithreading.lockBasedMechanism.synchronised;

public class ProduceTask implements Runnable{
    private SharedResource resource;

    public ProduceTask(SharedResource resource){
        this.resource = resource;
    }


    @Override
    public void run() {
        System.out.println("Producer Thread: "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        resource.addItem();
    }
}
