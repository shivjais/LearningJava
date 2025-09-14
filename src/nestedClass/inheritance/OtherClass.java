package nestedClass.inheritance;

//Non-static inner class inherited by different class
public class OtherClass extends NonStaticInner.InnerClass{
    OtherClass(){
        //as we know, when child class constructor invoked, it first invoked constructor of parent
        //but here the parent is Inner class, so it only be accessible by object of outer class only
        new NonStaticInner().super();
    }
}
