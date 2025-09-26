package switchDemo;

import sealedClassesAndInterfaces.Circle;
import sealedClassesAndInterfaces.Rectangle;
import sealedClassesAndInterfaces.Shape;

/** switch only support below types
 * - int, short, byte, char
 * - Integer, Short, Byte, Character
 * - Enum & String
 * but from java21 it also supports object like class, interface, abstract type, Wrapper object*/

public class SwitchWithPatternMatching {
    public static void main(String[] args) {

        Object obj = "Hello World";
        //this internally might use similar to what pattern matching of 'instanceOf' does to match the object type
        //Note that switch with object matching is slower that using switch with other data types
        switch (obj){
            case String s -> System.out.println("String: "+s); //scope of variable s is only within this case/block only
            case Integer i -> System.out.println("Integer: "+i);
            default -> System.out.println("Other type");
        }


        //Pattern matching with enum
        //without using pattern matching
        Object obj2 = Day.MONDAY;
        switch (obj2){
            case Day.MONDAY -> System.out.println("Day Monday");
            case Day.TUESDAY -> System.out.println("Day Tuesday");
            case Day.WEDNESDAY -> System.out.println("Day Wednesday");
            case Day.THURSDAY -> System.out.println("Day Thursday");
            default -> System.out.println("Other day");
        }

        //using pattern matching
        switch (obj2){
            case Day day -> System.out.println("Day "+day.name());
            default -> System.out.println("Other day");
        }

        //null handling with pattern matching
        /*Object obj3 = null;
        switch (obj3){
            case String s: System.out.println("String: "+s); break;
            default: System.out.println("null or Other type");
        }*/

        //Pattern matching not group multiple pattern
        Shape shape = new Circle();
        switch (shape){
            //case Circle circle, Rectangle r -> System.out.println("Circle & rectangle"); //this will not work
            case Circle c-> System.out.println("Circle");
            case Rectangle r-> System.out.println("Rectangle");

            default -> System.out.println("Other shape");
        }

        //Guarded Pattern: Helps to add additional condition on Pattern matching using 'when'
        //old switch
        switch (obj){
            case String s:
                if(s.contains("h") || s.contains("H")){
                    System.out.println("Old switch with condition");
                }
                break;
            default:
                System.out.println("Other case");
        }
        //new switch
        switch (obj){
            //when is considered as && operator
            //first it do pattern matching ie type casting. If true then check when condition
            case String s when (s.contains("h") || s.contains("H")):
                System.out.println("new switch with when condition");
                break;
            default:
                System.out.println("Other case");
        }


    }
}
