package com.cohort.vehicles;

public class GarageApp {

    public static void main (String[] args) {

        //Step3: Running the Polymorphism test
        Car car = new Car("Honda");
        Truck truck = new Truck("Hummer");

        car.start();
        truck.start();

        car.accelerate();
        truck.accelerate();

        car.soundHorn();
        truck.soundHorn();

        car.stop();
        truck.stop();
    }

}
