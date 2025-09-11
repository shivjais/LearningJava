package interfaceDemo;

public class Egle implements Bird{
    //concrete class must implement all abstract method all implemented interface
    //overridden methods can't have more restricted access modifiers
    @Override
    public void canFly() {

    }

    //We can't override the static method, if we are trying to do so
    //this will be considered as separate method
    //@Override
    public static boolean canBreathe(){
        return false;
    }

    public static void main(String[] args) {
        //accessing the static method
        boolean breathe = Bird.canBreathe();
        System.out.println(breathe);
    }
}
