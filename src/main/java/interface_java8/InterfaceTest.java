package interface_java8;

/*

    Before Java 8, interfaces could have only public abstract methods.
    It was not possible to add new functionality to the existing interface without forcing all implementing classes
        to create an implementation of the new methods, nor it was possible to create interface methods with an implementation.

    Starting with Java 8, interfaces can have static and default methods that,
        despite being declared in an interface, have a defined behavior.

 */

public class InterfaceTest
{
    /*
        Static Method
            -> The static producer() method is available only through and inside an interface.
                It can't be overridden by an implementing class.
            -> To call it outside the interface the standard approach for static method call should be used:
    */
    String producer = Vehicle.producer();


    /*
        Default methods are declared using the new default keyword.
            These are accessible through the instance of the implementing class and can be overridden.

        Assume that this interface is implemented by the class VehicleImpl.
            For executing the default method an instance of this class should be created:
    */
    Vehicle vehicle = new VehicleImpl();
    String overView = vehicle.getOverview();

}


