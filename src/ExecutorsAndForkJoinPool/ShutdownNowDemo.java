package ExecutorsAndForkJoinPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Shutdown interrupt the actively executing task
//halt the processing of task which are waiting & return the list of awaiting task
public class ShutdownNowDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(() -> {
            System.out.println("task executed by: " + Thread.currentThread().getName());
            Thread.sleep(15000);
            return "This is async task";
        });
        //after calling shutdown() executor will not accept new task submission
        //already submitted task will continue to execute
        executorService.shutdownNow();
        System.out.println("Executor service has been shutdown");

    }
}
