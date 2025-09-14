package nestedClass.inheritance;

//static Inner class can be inherited by different class
public class StaticInner {
    static class StaticInnerClass{
        public void display(){
            System.out.println("Inside StaticInnerClass");
        }
    }
}
