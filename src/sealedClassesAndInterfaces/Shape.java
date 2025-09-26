package sealedClassesAndInterfaces;

//Sealed classes or interface is introduced in java17
//sealed keyword is used with permits
//it brings the control like who can extend or implement this interface/class
//this interface can be extended/implement with permits list of interface/class
//permits type should be direct subclass of sealed interface/class
public sealed interface Shape permits Circle,Rectangle{
}
