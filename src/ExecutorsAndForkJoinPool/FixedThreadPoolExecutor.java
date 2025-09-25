package ExecutorsAndForkJoinPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Executors provide the factory methods which we can use to create a thread pool executor
//FixedThreadPoolExecutor is one of the executor
public class FixedThreadPoolExecutor {
    public static void main(String[] args) {
        //minPool & maxPool is same
        //used when we have exact info, how many async task is needed
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(() -> {
            System.out.println("task completed by: " + Thread.currentThread().getName());
            return "This is async task";
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
