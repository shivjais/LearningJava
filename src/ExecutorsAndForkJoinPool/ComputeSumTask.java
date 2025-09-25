package ExecutorsAndForkJoinPool;

import java.util.concurrent.RecursiveTask;

//To split the task into multiple subtask, task should implement one of below class
//recursive Task - when subtask returns anything we have to implement recursive task
//RecursiveAction -  when subtask not return anything we have to implement recursive action
public class ComputeSumTask extends RecursiveTask<Integer> {
    int start;
    int end;

    public ComputeSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    //we have to implement RecursiveTask to split & join threads
    @Override
    protected Integer compute() {

        if(end-start<=4){ //if we have 4 integer we iterate & find sum. It is like a base condition
            int total = 0;
            for (int i = start; i <= end; i++) {
                total += i;
            }
            return total;
        }else{
            //splitting the task
            int middle = (start+end)/2;
            ComputeSumTask leftTask = new ComputeSumTask(start, middle);
            ComputeSumTask rightTask = new ComputeSumTask(middle+1, end);

            //Fork the task for parallel execution
            //when we do fork() we divide the thread into 2 parts: leftTask & rightTask
            //one part thread start executing & other task is added in Work-stealing queue
            //From Work-stealing queue, this task can be executed by same or other thread as well
            //Work-stealing queue is a dequeue, where current thread will execute the task from front
            // & other thread will steal & execute the task from back
            leftTask.fork();
            rightTask.fork();

            //Here we wait both subtask to finish & get the result
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //Combine the results
            return leftResult + rightResult;

        }
    }
}
