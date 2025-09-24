package multithreading.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class OverloadedSubmitMethod {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        /** Submit(Runnable): Here we only pass the runnable task. because runnable didn't return any value
         * its return type is Future<?>
         */
        Future<?> future1 = threadPoolExecutor.submit(() -> System.out.println("Task with runnable"));

        try {
            //return type of runnable is void hence we can get result in any type, so we have store it in object
            Object object = future1.get();

            //this object always equal to null
            System.out.println(object==null);
        }
        catch (Exception e) {}

        /** Submit(Runnable,T): Here we pass the runnable task & shared object
         * when task completed thread executor will throw T object & we can catch it & use this updated object
         * its return type is Future<T>
         */
        List<Integer> list = new ArrayList<>();
        Future<List<Integer>> future2 = threadPoolExecutor.submit(new MyRunnable(list),list);

        try {

            List<Integer> integers = future2.get();
            System.out.println("Getting using future: "+integers);

            //another way: getting the result directly from updated list
            System.out.println("Getting using list: "+list);
        }
        catch (Exception e) {}

        /** submit(Callable): Here we pass the callable task & it returns the result.
         * it is cleaner way than above to get the result
         */

        Future<List<Integer>> future3 = threadPoolExecutor.submit(() -> {
            List<Integer> list1 = new ArrayList<>();
            list1.add(800);
            return list1;
        });
        
        try {
            List<Integer> integers = future3.get();
            System.out.println("Getting using callable: "+integers);
        }
        catch (Exception e) {}
        

        threadPoolExecutor.shutdown();
    }
}
