package ExecutorsAndForkJoinPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(6000);
            System.out.println("task completed by: " + Thread.currentThread().getName());
            return "This is async task";
        });
        executorService.shutdown();
        try {

            //awaitTermination() is called after calling shutdown() & it is optional functionality
            //this is used when we have to perform some task after executor service is shutdown
            // here main thread will wait for 2 sec to check is executor service is shutdown or not.
            // but it won't because thread is running until 6 sec, so it returns false
            boolean isTerminated = executorService.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("executorService isTerminated: " + isTerminated);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Thread terminated");
    }
}
