package nestedClass.nonStaticNested;

//non-static class present inside a class
public class MemberInnerClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    //This class can be private, protected, public & default
    class InnerClass{
        public void print(){
            //can access non-static member as well
            System.out.println(classVariable + ":" + instanceVariable);
        }
    }
}
