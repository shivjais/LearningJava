package multithreading.completableFuture;

import java.util.concurrent.*;

/** thenCombine() & thenCombineAsync() used t combine result of two comparable feature
 */
public class ThenCombineAndThenCombineAsyncDemo {
    public static void main(String[] args) {
        try {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


            //thenAcceptAsync() is the asynchronous execution that is it uses diff thread that executed the previous task
            CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(()-> {
                        System.out.println("task1 completed by: "+Thread.currentThread().getName());
                    return 10;
                }, threadPoolExecutor);

            CompletableFuture<String> task2 = CompletableFuture.supplyAsync(()->{
                        System.out.println("task2 completed by: "+Thread.currentThread().getName());
                        return "k";
                    }, threadPoolExecutor);
            CompletableFuture<String> result = task1.thenCombine(task2,(Integer val1,String val2)->val1+val2);

            System.out.println(result.get());
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
        }
    }
}
