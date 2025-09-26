package switchDemo;

//return statements are not allowed in switch. there are 2 ways to do the same (introduced in java14)
//using "Case N -> " label or using yield statement
public class SwitchWithReturn {
    public static void main(String[] args) {

        //use of "Case N -> "
        int val = 1;
        //here all possible use cases needs to handled (or use default if we don't want to cover all case) if we use switch as expression
        //if we don't want to return any value to any case we can throw exception as well
        //using this when we can't have block statements, if there is block statement then we have to use yield
        String output = switch (val){
            case 1 -> "One"; //no need of break
            case 2 -> "Two";
            default -> "Default";
        }; //semicolon is required here (end of assignment here)
        System.out.println(output);

        //use of yield
        val=2;
        output = switch (val){
          case 1 -> {
              //some logic
              yield "One";
          }
          case 2 -> {yield "Two";}
          default -> "None";
        };
        System.out.println(output);

    }
}
