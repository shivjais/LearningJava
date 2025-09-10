package immutableClass;

import java.util.ArrayList;
import java.util.List;

//class should be final
public final class MyImmutable {

    //instance variable should be private & final
    private final String name;
    private final List<String> petNames;

    //instance variable will set via constructor only
    public MyImmutable(String name, List<String> petNames) {
        this.name = name;
        this.petNames = petNames;
    }

    //instance variable will be accessible via getter method only
    public String getName() {
        return name;
    }

    public List<String> getPetNames() {
        //always return the copy of member variable
        return new ArrayList<>(petNames);
    }
}
