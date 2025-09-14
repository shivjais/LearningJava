package reflection;

import java.lang.reflect.*;
import java.util.Objects;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //Getting Class object
        //Approach-1: using forName()
        Class<?> egleClass = Class.forName("reflection.Egle");
        //Approach-2: using .class
        //Class<Egle> egleClass = Egle.class;
        //Approach-3: using getClass()
        //Egle egle = new Egle();
        //Class<?> egleClass = egle.getClass();
        System.out.println(egleClass.getName()); //getting name of class
        System.out.println(Modifier.toString(egleClass.getModifiers())); //getting modifier of class

        Method[] methods = egleClass.getMethods(); //get all the public methods of egle class & also parent(Object) class methods
        System.out.println("********************");
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getParameterCount());
            System.out.println(method.getDeclaringClass());
            System.out.println("********************");
        }

        Method[] declaredMethods = egleClass.getDeclaredMethods();//returns all the method (public/private) for egle class only
        for (Method method : declaredMethods) {
            System.out.println("Method Name: "+method.getName());
        }

        //invoking method using reflection
        Constructor<?> declaredConstructor = egleClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Egle egleObj = (Egle) declaredConstructor.newInstance(); //this internally invokes egle class constructor
        Method flyMethod = egleClass.getMethod("fly", int.class, boolean.class, String.class);
        flyMethod.invoke(egleObj,1,true,"hello");

        //getting public fields only
        Field[] fields = egleClass.getFields();
        for (Field field : fields) {
            System.out.println("Field Name: "+field.getName());
            System.out.println("Field Type: "+field.getType());
            System.out.println("Modifiers: "+Modifier.toString(field.getModifiers()));
            System.out.println("************************");
        }

        //getting both public & private fields only
        Field[] declaredFields = egleClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("Declared Field Name: "+field.getName());
            System.out.println("Field Type: "+field.getType());
            System.out.println("Modifiers: "+Modifier.toString(field.getModifiers()));
            System.out.println("***********************");
        }

        //Setting value of public field
        //getDeclaredField() return both public & private fields
        Field field = egleClass.getDeclaredField("breed");
        field.set(egleObj,"Brown Egle");
        System.out.println("Breed: "+egleObj.breed);

        //Setting value of private field
        field = egleClass.getDeclaredField("canSwim");
        field.setAccessible(true); //allowing private field to accessible outside the class
        field.set(egleObj,false);
        System.out.println("CanSwim: "+field.getBoolean(egleObj));

        //accessing constructor of a class
        Constructor<?>[] declaredConstructors = egleClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("Constructor Name: "+constructor.getName());
            System.out.println("Modifiers: "+Modifier.toString(constructor.getModifiers()));

            constructor.setAccessible(true);
            Egle egleObj1;
            if(Objects.equals(Modifier.toString(constructor.getModifiers()), "private")){
                //here we are able to access private constructor as well, hence its breaking singleton design pattern
                egleObj1 =  (Egle) constructor.newInstance(); //private constructor have no args
            }
            else
            {
                egleObj1 =  (Egle) constructor.newInstance("newBreed"); //public constructor have args
            }

            egleObj1.fly();
        }

    }
}
