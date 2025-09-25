package ExecutorsAndForkJoinPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ShutdownDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(6000);
            System.out.println("task completed by: " + Thread.currentThread().getName());
            return "This is async task";
        });
        //after calling shutdown() executor will not accept new task submission
        //already submitted task will continue to execute
        executorService.shutdown();
        System.out.println("Executor service has been shutdown");

        //try to submit task after shutdown executor results RejectedExecutionException
       executorService.submit(() -> {
            System.out.println("task submitted after shutdown: " + Thread.currentThread().getName());
            return "This is async task";
        });
    }
}
