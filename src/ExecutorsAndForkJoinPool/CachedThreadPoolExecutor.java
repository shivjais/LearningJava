package ExecutorsAndForkJoinPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutor {
    public static void main(String[] args) {
        //newCachedThreadPool() create a new thread pool that create a new thread as needed(dynamically)
        //minPoolthread = 0 & maxPoolThread = Integer.MAX_VALUE
        //this is good for handling of short-lived task
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            System.out.println("Task competed by: "+Thread.currentThread().getName());

        });
    }
}
