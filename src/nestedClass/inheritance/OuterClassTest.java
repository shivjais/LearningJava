package nestedClass.inheritance;

public class OuterClassTest {
    public static void main(String[] args) {
        OuterClass instance = new OuterClass();
        OuterClass.InnerClass2 innerClass2 = instance.new InnerClass2();
        innerClass2.display();
    }
}
