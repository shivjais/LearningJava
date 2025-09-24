package multithreading.completableFuture;


import java.util.List;

public class MyRunnable implements Runnable{
    private List<Integer> list;

    MyRunnable(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        list.add(300);
    }
}
