package nestedClass.inheritance;

//One inner class can inherit another inner class in same outer class
public class OuterClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    class InnerClass1 {
        int innerClass1 = 3;
    }
    class InnerClass2 extends InnerClass1 {
        int innerClass2 = 4;

        void display() {
            System.out.println(innerClass1+innerClass2+instanceVariable+classVariable);
        }
    }
}
