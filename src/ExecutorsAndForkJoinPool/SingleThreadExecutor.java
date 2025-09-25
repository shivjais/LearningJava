package ExecutorsAndForkJoinPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        //newSingleThreadExecutor() create a new thread pool that create one worker thread only
        //minPoolThread = 1 & maxPoolThread = 1
        //this is good when need to process task sequentially
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            System.out.println("Task competed by: "+Thread.currentThread().getName());

        });
    }
}
