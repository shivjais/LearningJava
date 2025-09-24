package multithreading.completableFuture;

import java.util.concurrent.*;

/** thenCompose() & thenComposeAsync()  is used when you have one CompletableFuture object that returns another CompletableFuture
 * object as its result, and you want to execute the second task after the first one has completed.
 * that is, for async task we can bring some ordering using these methods
 */
public class ThenComposeAndThenComposeAsyncDemo {
    public static void main(String[] args) {
        try {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


            //thenComposeAsync() is the non-synchronous execution that is it uses different thread that executed the previous task
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> {
                        System.out.println("supply async task completed by: "+Thread.currentThread().getName());
                    return "Learing";
                }, threadPoolExecutor)
                    .thenComposeAsync((val)-> {
                        System.out.println("thenComposeAsync1 completed by: "+Thread.currentThread().getName());
                        return CompletableFuture.supplyAsync(()->val+" Computable");
                    }, threadPoolExecutor)
                    .thenComposeAsync((val)-> {
                        System.out.println("thenComposeAsync2 completed by: "+Thread.currentThread().getName());
                        return CompletableFuture.supplyAsync(()->val+" Feature");
                    }, threadPoolExecutor);

            System.out.println(completableFuture.get());
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
        }
    }
}
