package multithreading.lockBasedMechanism.synchronised;

public class SharedResource {

    boolean isItemAvailable = false;

    public synchronized void addItem(){
        isItemAvailable = true;
        System.out.println("Item added by: "+Thread.currentThread().getName()+" and invoking other threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consumption of item is invoked by: "+Thread.currentThread().getName());
        if(!isItemAvailable){
            try {
                System.out.println("Item is not available. Thread "+Thread.currentThread().getName()+" is waiting");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Item is consumed by: "+Thread.currentThread().getName());
        isItemAvailable = false;
    }
}
