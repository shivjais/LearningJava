package enumDemo;

public class Main {
    public static void main(String[] args) {
        //use of values(), name(), ordinal() & valueOf() method of enum
        //these methods are not defined in ENUM but still we are able to access them
        //because these methods are defined in java.lang.Enum class which is internally extended by all enums

        SimpleEnum[] simpleEnums = SimpleEnum.values();
        for (SimpleEnum simpleEnum : simpleEnums) {
            System.out.println(simpleEnum.ordinal()); //default values assigned to each num values
        }

        SimpleEnum simpleEnum = SimpleEnum.valueOf("MONDAY");
        System.out.println(simpleEnum.name());

        EnumWithParams enumWithParams = EnumWithParams.getEnumFromValue(107);
        System.out.println("enumWithParams: "+enumWithParams);
        System.out.println("enumWithParams desc: "+enumWithParams.getDescription());

        EnumWithOverrideMethod overrideMethod = EnumWithOverrideMethod.FRIDAY;
        overrideMethod.dummyMethod();
        EnumWithOverrideMethod overrideMethod1 = EnumWithOverrideMethod.MONDAY;
        overrideMethod1.dummyMethod();

        EnumWithAbstractMethod enumWithAbstractMethod = EnumWithAbstractMethod.MONDAY;
        enumWithAbstractMethod.dummyMethod();

        EnumWithInterface enumWithInterface = EnumWithInterface.MONDAY;
        System.out.println("enumWithInterface: "+enumWithInterface.toLowerCase());
    }
}
