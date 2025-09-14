package nestedClass.nonStaticNested;

//Local Inner class present inside the method
public class LocalInnerClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    public void display(){
        int methodVariable = 3;

        //this class has same scope as this method have
        class LocalInner{
            int localInnerVariable = 4;

            public void print(){
                System.out.println(instanceVariable+":"+classVariable+":"+methodVariable+":"+localInnerVariable);
            }
        }

        //Local Inner class can be invoked inside method only because its scope is limited to method only
        LocalInner localInner = new LocalInner();
        localInner.print();
    }
}
