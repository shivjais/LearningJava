package nestedClass.staticNested;

public class StaticNestedDemo {
    public static void main(String[] args) {
        //static nested class can be access directly with outer class Name
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        innerClass.print();

        //accessing methods of private nested class
        PrivateStaticNestedClass privateStaticNestedClass = new PrivateStaticNestedClass();
        privateStaticNestedClass.display();
    }
}
