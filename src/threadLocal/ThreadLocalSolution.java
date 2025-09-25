package threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** In Thread pool, once we set the value of any thread using thread Local then
 *  we have removed it because Thread local is specific to that thread
 *  & when we reuse the thread from pool its value always be set
 * */
public class ThreadLocalSolution {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal =  new ThreadLocal<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //setting value for this thread
        executorService.submit(()-> {
            threadLocal.set(Thread.currentThread().getName());
            //removing thread local variable for this thread
            threadLocal.remove();
        });


        for (int i = 0; i < 15; i++) {
            //now we will not get above local thread value & we get null
            executorService.submit(()-> System.out.println(threadLocal.get()));
        }
        executorService.shutdown();
    }
}
