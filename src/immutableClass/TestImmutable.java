package immutableClass;

import java.util.List;

public class TestImmutable {
    public static void main(String[] args) {
        MyImmutable immutable = new MyImmutable("shivam", List.of("abc","def"));
        immutable.getPetNames().add("xyz");
        System.out.println(immutable.getPetNames());
    }
}
