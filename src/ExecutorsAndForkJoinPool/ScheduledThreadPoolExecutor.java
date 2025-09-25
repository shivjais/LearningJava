package ExecutorsAndForkJoinPool;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //min Thread = 5 & maxThread=Integer.MAX_VALUE
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        //printed hello after delay of 5 sec
        //executorService.schedule(()-> System.out.println("Hello"),5, TimeUnit.SECONDS);

        //This takes callable object & printed hello after delay of 5 sec
        //Future<String> schedule = executorService.schedule(() -> "Hello", 5, TimeUnit.SECONDS);
        //System.out.println("result: "+schedule.get());

        //it executes the task after given initial delay & repeats given period of time
        //when executing task takes more time than defined period, next task still gets scheduled but not execute
        //and as soon as current executing task finish next task will get executed.
        Future<?> future = executorService.scheduleAtFixedRate(() -> {
            System.out.println("New tasked picked by: " + Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread completed the task");
        },1, 3, TimeUnit.SECONDS);

        Thread.sleep(10000);
        //interrupting above task after 10 sec
        future.cancel(true);
        System.out.println("Task interrupted");


        //it executes the task after given initial delay & repeats given delay of time after completion of prevous task
        //when executing task takes more time than defined period, next task not gets scheduled.
        //it will schedule after executing task complete & execute after given delay

        System.out.println("scheduleWithFixedDelay");
        executorService.scheduleWithFixedDelay(() -> {
            System.out.println("New tasked picked by: " + Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread completed the task");
        },1, 3, TimeUnit.SECONDS);

    }
}
