package multithreading.lockFreeMechanism.withoutLockFree;

public class SharedResource {
    private int counter;

    public void increment(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }
}
