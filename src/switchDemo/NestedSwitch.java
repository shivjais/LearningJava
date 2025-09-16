package switchDemo;

public class NestedSwitch {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
        int output = 0;

        switch (day) {
            case MONDAY:
                output = 1;
                switch (output){
                    case 1:
                        System.out.println("output value is 1");
                        break;
                    case 2:
                        System.out.println("output value is 2");
                        break;
                    default:
                        System.out.println("output value is "+output);
                }
                break;
            case TUESDAY:
                output = 2;
                break;
            case WEDNESDAY:
                output = 3;
                break;
        }
    }
}
