package multithreading.threadPoolExecutor;

import java.util.concurrent.*;

//Helps to create customizable ThreadPool
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),new CustomThreadFactory(),//new ThreadPoolExecutor.DiscardPolicy()
                new CustomRejectedHandler());

        //if this will be true then only thread will be removed from thread pool
        //when it is idele from last keepAliveTime
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        //submit task
        for (int i = 0; i < 7; i++) {
            threadPoolExecutor.submit(()->{
                try{
                    Thread.sleep(2000);
                    System.out.println("Thread Name : "+Thread.currentThread().getName());
                }
                catch (InterruptedException e){}
            });
        }
        threadPoolExecutor.shutdown();
    }
}

class CustomRejectedHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //Logging
        System.out.println("Task Denied: "+r.toString());
    }
}
class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        //thread.setDaemon(true);
        //thread.setName("custom-thread");
        //thread.setPriority(Thread.NORM_PRIORITY);
        return thread;
    }
}
