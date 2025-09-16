package switchDemo;

//int, short, byte, char & their wrapper classes, Enum & String are allowed datatypes in switch
public class SwitchWithEnum {
    public static void main(String[] args) {
        Day day = Day.SATURDAY;
        int output = 0;

        //in switch all the cases need not to handle
        switch (day) {
            case MONDAY:
                output = 1;
                break;
            case TUESDAY:
                output = 2;
                break;
            case WEDNESDAY:
                output = 3;
                break;
            case THURSDAY:
                output = 4;
                break;

        }
        System.out.println(output);
    }
}
