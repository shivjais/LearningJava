package nestedClass.staticNested;

public class OuterClass {
    int instaceVaribale = 10;
    static int classVariable = 20;

    //This class can be private, protected, public & default
    static class InnerClass{
        public void print(){
            System.out.println(classVariable);
            //we can't access non static member from static context
            //System.out.println(instaceVaribale);
        }
    }
}
