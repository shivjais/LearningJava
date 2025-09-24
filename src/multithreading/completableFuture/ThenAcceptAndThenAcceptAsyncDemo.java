package multithreading.completableFuture;

import java.util.concurrent.*;

/** thenAccept() & thenAcceptAsync()  These methods are used to consume the result of a task, without returning a value
 */
public class ThenAcceptAndThenAcceptAsyncDemo {
    public static void main(String[] args) {
        try {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


            //thenAcceptAsync() is the asynchronous execution that is it uses diff thread that executed the previous task
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(()-> {
                        System.out.println("supply async task completed by: "+Thread.currentThread().getName());
                    return "Learning";
                }, threadPoolExecutor)
                    .thenAcceptAsync((val)-> {
                        System.out.println("thenAcceptAsync completed by: "+Thread.currentThread().getName());
                        System.out.println("Val will be: "+val+" Complete Future");
                    }, threadPoolExecutor);

            //this always return null
            System.out.println(completableFuture.get());
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
        }
    }
}
