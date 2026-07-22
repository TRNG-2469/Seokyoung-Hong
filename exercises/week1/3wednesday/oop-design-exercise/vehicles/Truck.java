package com.cohort.vehicles;

public class Truck extends Vehicle implements Driveable {

    public Truck(String model) {
        super(model);
    }

    public void accelerate() {
        this.speed += 10.0;
        System.out.println("Accelerated by 10mph! The speed is now " + this.speed + ".");
    }

    public void start() {
        System.out.println("Truck engine started!");
    }

    @Override
    public void soundHorn() {
        System.out.println("BEEEEEEEEEEEEEEEEP");
    }

}
