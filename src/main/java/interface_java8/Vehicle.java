package interface_java8;

/*
    interface_java8.Vehicle Interface with static and default methods
 */

public interface Vehicle {
    void moveTo(long altitude, long longitude);

    static String producer() {
        return "N&F Vehicles";
    }

    default long[] startPosition() {
        return new long[] { 23, 15 };
    }

    default String getOverview() {
        return "ATV made by " + producer();
    }

}
