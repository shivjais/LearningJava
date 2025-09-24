package multithreading.completableFuture;

import java.util.concurrent.*;

//thenApply() & thenApplyAsync() apply a function to result of previous computation & return new CompletableFuture object
public class ThenApplyAndThenApplyAsyncDemo {
    public static void main(String[] args) {
        try {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


            //thenApply() is the synchronous execution that is it uses same thread that executed the previous task
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> {
                        System.out.println("supply async task completed by: "+Thread.currentThread().getName());
                    return "Learning ";
                }, threadPoolExecutor)
                    .thenApply((val)-> {
                        System.out.println("then Apply completed by: "+Thread.currentThread().getName());
                        return val+" Computable Feature";
                    });

            System.out.println(completableFuture.get());

            //thenApplyAsync() is the asynchronous execution that is it uses different thread that executed the previous task
            //this another thread will be from fork-join pool if thread pool is not provided other will be from provided one
            completableFuture = CompletableFuture.supplyAsync(()-> {
                        System.out.println("supply async task completed by: "+Thread.currentThread().getName());
                        return "Learning";
                    }, threadPoolExecutor)
                    .thenApplyAsync((val)-> {
                            System.out.println("then Apply Async completed by: "+Thread.currentThread().getName());
                            return val+" Computable Feature";
                        }, threadPoolExecutor
                    );

            System.out.println(completableFuture.get());
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
        }

    }
}
