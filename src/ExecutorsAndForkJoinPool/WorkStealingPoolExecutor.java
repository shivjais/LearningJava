package ExecutorsAndForkJoinPool;

import java.util.concurrent.*;

//WorkStealingPoolExecutor creates Fork-join pool executor
//task can be split into multiple subtask for that we need to extend Recursive task & Recursive action
public class WorkStealingPoolExecutor {
    public static void main(String[] args) {

        //we can also use this to create fork-join pool executor & no of thread = no of available processor
        //ExecutorService executorService = Executors.newWorkStealingPool();
        //below method create 5 thread in fork-join pool executor
        //ExecutorService executorService = Executors.newWorkStealingPool(5);


        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool(); // another way to create fork-join pool executor
        //when we do submit task goes to submission queue & when we do fork() task goes to work-stealing queue of thread
        Future<Integer> submitFuture = forkJoinPool.submit(new ComputeSumTask(0, 100));

        try {
            System.out.println(submitFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
