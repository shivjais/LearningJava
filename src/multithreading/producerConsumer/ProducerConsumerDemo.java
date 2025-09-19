package multithreading.producerConsumer;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue(3);

        //creating producer thread
        Thread producerThread = new Thread(()->{
            try {
                for(int i=0;i<=6;i++){
                    sharedQueue.produceItem(i);
                }
            }
            catch (InterruptedException e) {
            }
        });

        //creating consumer thread
        Thread consumerThread = new Thread(()->{
            try {
                for(int i=0;i<=6;i++){
                    sharedQueue.consumeItem();
                }
            }
            catch (InterruptedException e) {}
        });
        producerThread.start();
        consumerThread.start();
    }
}
