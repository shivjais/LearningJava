package enumDemo;

//we can use interface when we have methods common to all values
public enum EnumWithInterface implements MyInterface {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    SUNDAY;

    @Override
    public String toLowerCase() {
        return name().toLowerCase();
    }
}
