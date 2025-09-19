package multithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    private Queue<Integer> sharedQueue;
    int bufferSize;

    public SharedQueue(int bufferSize) {
        this.bufferSize = bufferSize;
        sharedQueue = new LinkedList<>();
    }

    public synchronized void produceItem(int item) throws InterruptedException {
        System.out.println("Producer Thread Start: "+Thread.currentThread().getName());
        if(sharedQueue.size() == bufferSize){
            System.out.println("Buffer is full, producer is waiting for consumer");
            wait();
        }

        sharedQueue.add(item);
        System.out.println("Produced  Item: "+item);
        notify();
    }

    public synchronized void consumeItem() throws InterruptedException {
        System.out.println("Consumer Thread Start: "+Thread.currentThread().getName());
        if (sharedQueue.isEmpty()) {
            System.out.println("Buffer is empty, consumer is waiting for producer");
            wait();
        }
        Integer item = sharedQueue.poll();
        System.out.println("Consumed  Item: "+item);
        notify();
    }



}
