package multithreading.completableFuture;


import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //New thread will be created & it will perform the task (Runnable task)
        Future<?> future = threadPoolExecutor.submit(() -> {
            try{
                //thread takes 7 sec to complete task
                Thread.sleep(7000);
                System.out.println("This task will get executed by the thread");
                return;
            }
            catch (InterruptedException e){}
        });

        //caller is checking the status of thread it created
        System.out.println("is Task completed: "+future.isDone());

        try {
            //main thread will wait for 2 sec & if task completed within it returns the result otherwise throw exception
            future.get(2,TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.err.println("Timeout happened");
        } catch (Exception e) {}

        try {
            //main thread will wait until task will be completed by above thread
            future.get();
        } catch (Exception e) {
        }

        System.out.println("is Task completed: "+future.isDone());
        System.out.println("is Task cancelled: "+future.isCancelled());
        threadPoolExecutor.shutdown();
    }
}
