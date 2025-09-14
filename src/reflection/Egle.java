package reflection;

public class Egle {
    public String breed;
    private boolean canSwim;

    private Egle(){}
    public Egle(String breed) {}

    public void fly(){
        System.out.println("can fly");
    }

    private void eat(){
        System.out.println("can eat");
    }

    public void fly(int intParam,boolean boolParam,String stringParam){
        System.out.println("intParam: "+intParam+" boolParam: "+boolParam+" stringParam: "+stringParam);
    }
}
