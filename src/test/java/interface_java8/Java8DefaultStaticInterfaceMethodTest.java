package interface_java8;

/*
    Before Java 8, interfaces could have only public abstract methods.
    It was not possible to add new functionality to the existing interface without forcing all implementing classes
        to create an implementation of the new methods, nor it was possible to create interface methods with an implementation.

    Starting with Java 8, interfaces can have static and default methods that,
        despite being declared in an interface, have a defined behavior.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Java8DefaultStaticInterfaceMethodTest {

    /*
        Static Method
            -> The static producer() method is available only through and inside an interface.
                It can't be overridden by an implementing class.
            -> To call it outside the interface the standard approach for static method call should be used:
    */
    @Test
    public void callInterfaceStaticMethodTest() {
        Vehicle vehicle = new VehicleImpl();
        String overview = vehicle.getOverview();

        long[] startPosition = vehicle.startPosition();

        assertEquals(overview, "ATV made by N&F Vehicles");
        assertEquals(startPosition[0], 23);
        assertEquals(startPosition[1], 15);
    }


    /*
        Default methods are declared using the new default keyword.
            These are accessible through the instance of the implementing class and can be overridden.

        Assume that this interface is implemented by the class VehicleImpl.
            For executing the default method an instance of this class should be created:
    */
    @Test
    public void callInterfaceDefaultMethodTest() {
        String producer = Vehicle.producer();
        assertEquals(producer, "N&F Vehicles");
    }
}
