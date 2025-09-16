package switchDemo;

public class SwitchWithVariable {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        //Case can be in any order
        switch (a+b){
            case 1:
                System.out.println("a+b is 1");
                break;
            case 2:
                System.out.println("a+b is 2");
                break;
            case 3:
                System.out.println("a+b is 3");
                break;
            default:
                System.out.println("a+b is default");
                break;
        }
    }
}
