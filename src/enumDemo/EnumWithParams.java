package enumDemo;

public enum EnumWithParams {
    MONDAY(101,"this is monday"),
    TUESDAY(102,"this is tuesday"),
    WEDNESDAY(103,"this is wednesday"),
    THURSDAY(104,"this is thusday"),
    FRIDAY(105,"this is friday"),
    SATURDAY(106,"this is saturday"),
    SUNDAY(107,"this is sunday");

    //this value & description is applicable for all enum values
    private int value;
    private String description;

    //By default, the constructor of enums are private
    EnumWithParams(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }

    public static EnumWithParams getEnumFromValue(int value) {
        for (EnumWithParams simpleEnum : EnumWithParams.values()) {
            if (simpleEnum.value == value) {
                return simpleEnum;
            }
        }
        return null;
    }
}
