package switchDemo;

//return statements are not allowed in switch. there are 2 ways to do the same
//using "Case N -> " label or using yield statement
public class SwitchWithReturn {
    public static void main(String[] args) {

        //use of "Case N -> "
        int val = 1;
        //here all possible use cases needs to handled (default as well)
        //using this we can't have block statements, if there is block statement then we have to use yield
        String output = switch (val){
            case 1 -> "One"; //there is no need to break statement here
            case 2 -> "Two";
            default -> "Default";
        };
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
