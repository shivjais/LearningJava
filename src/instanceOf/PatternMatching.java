package instanceOf;

//it is introduced in java16
public class PatternMatching {
    public static void main(String[] args) {
        Object obj = "test";

        //old way to use instance of
        if(obj instanceof String){
            String s = (String) obj;
            System.out.println("Old way: "+s);
        }

        //new way introduced in java16
        //here first comparison happens. If true, then obj automatically type case to & initialize to string s
        if(obj instanceof String s){
            System.out.println("New way: "+s);
        }
        //scope of String s is only with the above if block
        //System.out.println(s);

        //we can also use && operator
        Object obj2 = 5;
        if(obj2 instanceof Integer i && i<10 ){
            System.out.println("Value less than 10");
        }

        //but pattern matching doesn't work with OR operator
        //if(obj2 instanceof Integer i || i < 10){}

        //Pattern matching also works with interface
        Object obj3 = new TwoWheeler();
        if(obj3 instanceof TwoWheeler twoWheeler){
            twoWheeler.drive();
        }
    }
}
