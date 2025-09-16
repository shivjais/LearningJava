package switchDemo;

public class SwitchWithExpression {
    public static void main(String[] args) {
        //case value should either be constant or literal
        final int value = 1;

        switch (2+1-2){
            case value:
                System.out.println("Case matched");
                break;
            default:
                System.out.println("Case not matched");
                break;
        }
    }
}
