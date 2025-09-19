package multithreading.lockBasedMechanism.synchronised;

public class SharedResourceDemo {
    public static void main(String[] args) {
        SharedResource  sharedResource = new SharedResource();

        Thread producerThread = new Thread(new ProduceTask(sharedResource));
        Thread consumerThread = new Thread(new ConsumerTask(sharedResource));
        producerThread.start();
        consumerThread.start();

        System.out.println("Main Thread End");
    }
}
