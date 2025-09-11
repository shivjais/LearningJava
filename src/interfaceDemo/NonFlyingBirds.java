package interfaceDemo;

//An interface can extend more than one interface
public interface NonFlyingBirds extends Bird, LivingThings {

    //anu child class can make default method to abstract as well
    public abstract void canRun();

    //if both implementing interface have same default methods
    // then we have to override default method in child class
    @Override
    default void canEat() {
        //this way we can call parent class default method
        Bird.super.canEat();
    }

    //overriding the default method, but this is not mandatory
    default void fly(){
    }

}
