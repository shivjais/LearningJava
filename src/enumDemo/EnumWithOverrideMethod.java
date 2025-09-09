package enumDemo;

public enum EnumWithOverrideMethod {
    MONDAY{
        //if we want to override the default method
        @Override
        public void dummyMethod() {
            System.out.println("dummyMethod inside monday");
        }
    },
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    //this method is applicable for values
    public void dummyMethod() {
        System.out.println("this is dummy method");
    }
}
