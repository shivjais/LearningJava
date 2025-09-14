package nestedClass.nonStaticNested;

//Inner class without the name
//used when we want to override the behaviour of method without creating subclass
public class AnonymousClass {
    public static void main(String[] args) {
        Car car = new Car() {
            @Override
            public void pressBreak() {
                System.out.println("Pressing car break");
            }
        };
        car.pressBreak();
    }
}
