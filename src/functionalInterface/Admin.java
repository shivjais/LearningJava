package functionalInterface;

public class Admin implements  User{
    //here we don't need to override object class method because it is by default present in all class
    @Override
    public String getName() {
        return "";
    }
}
