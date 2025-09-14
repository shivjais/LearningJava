package nestedClass.nonStaticNested;

public class MemberInnerDemo {
    public static void main(String[] args) {
        MemberInnerClass outerClass = new MemberInnerClass();
        MemberInnerClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.print();
    }
}
