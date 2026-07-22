class Vehicle {}
class Car extends Vehicle {}
class Airplane extends Vehicle {}

/* Old
public class AirportApp {
    public static void main(String[] args) {
        Vehicle myVehicle = new Airplane();

        // Triggers ClassCastException at runtime
        Car myCar = (Car) myVehicle;
        System.out.println("Vehicle downcasted successfully.");
    }
} */

//AI Response
public class AirportApp {
    public static void main(String[] args) {
        Vehicle myVehicle = new Airplane();

        if (myVehicle instanceof Car) {
            Car myCar = (Car) myVehicle;
            System.out.println("Vehicle downcasted successfully.");
        } else {
            System.out.println("The vehicle is not a Car.");
        }
    }
}