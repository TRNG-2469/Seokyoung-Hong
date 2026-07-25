package com.cohort.vehicles;

public class Car extends Vehicle implements Driveable {

    public Car(String model) {
        super(model);
    }

    public void accelerate() {
        this.speed += 20.0;
        System.out.println("Accelerated by 20mph! The speed is now " + this.speed + ".");
    }

    public void start() {
        System.out.println("Engine started!");
    }


}
