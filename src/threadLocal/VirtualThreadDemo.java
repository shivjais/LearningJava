package threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Virtual thread vs platform thread (normal thread) ==> Imp
public class VirtualThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = Thread.ofVirtual().start(() -> System.out.println("Running inside virtual thread: " + Thread.currentThread().getName()));


        //another way to create virtual thread
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(()-> System.out.println("Running inside another virtual thread: " + Thread.currentThread().getName()));
    }
}
