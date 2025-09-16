package switchDemo;

//two cases must not have same value
public class SwitchWithString {
    public static void main(String[] args) {
        String month = "March";

        switch (month){
            //statement with multiple cases
            case "January":
            case "February":
            case "March":
                System.out.println("Month Value is in Q1");
                break;
            //multiple case can also define in this way
            case "April", "May", "June":
                System.out.println("Month Value is in Q2");
                break;
            default:
                System.out.println("Month Value is in Q3 or Q4");
                break;
        }
    }
}
