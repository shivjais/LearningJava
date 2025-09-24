package multithreading.completableFuture;

import java.util.concurrent.*;

public class SupplyAsyncDemo {
    public static void main(String[] args) {
        try {
            //in supplyAsync() we need to pass the task which we want to execute via thread
            //below we have not provided any executor hence it uses default fork-join pool to create a thread
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->  "task completed by "+Thread.currentThread().getName());
            System.out.println(completableFuture.get());

            //below we have pass the ThreadPoolExecutor so all the thread will be used from this pool
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            completableFuture = CompletableFuture.supplyAsync(()->  "task completed by "+Thread.currentThread().getName(), threadPoolExecutor);
            System.out.println(completableFuture.get());

            threadPoolExecutor.shutdown();
        } catch (Exception e) {
        }

    }
}
