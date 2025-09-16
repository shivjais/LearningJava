package switchDemo;

public class SwitchWithBVariableWithoutBreak {
    public static void main(String[] args) {
        int a = 1;
        int b = 9;
        //default can be present anywhere in switch
        //if we don't use break all statement will get executed after matching a case
        switch (a+b){
            case 1:
                System.out.println("a+b is 1");
                break;
            case 2:
                System.out.println("a+b is 2");
                break;
            default:
                System.out.println("a+b is default");
            case 3:
                System.out.println("a+b is 3");
            case 4:
                System.out.println("a+b is 4");
                break;

        }
    }
}
