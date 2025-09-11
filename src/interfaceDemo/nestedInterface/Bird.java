package interfaceDemo.nestedInterface;

public interface Bird {
    void canFly();

    //nested interface must be public
    public interface NonFlyingBird{
        void canRun();
    }
}
