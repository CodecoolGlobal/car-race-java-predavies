package com.codecool.car_race.vehicle;

import com.codecool.car_race.Race;

public abstract class Vehicle { // abstraction? When && Why to use nested classes?
    protected String name; // difference between private and protected?
    protected int normalSpeed;
    protected int actualSpeed;
    protected int distanceTravelled;

    protected Vehicle(int normalSpeed) {
        this.name = generateName();
        this.normalSpeed = normalSpeed;
    }

    public abstract void prepareForLap(Race race);

    public abstract String generateName();

    public final void moveForAnHour() {
        distanceTravelled += actualSpeed;
    }

    @Override
    public String toString() { // Why is string builder used and is it a better method? .append?

        return "{" + "Distance travelled: " + distanceTravelled + ",  " +
                "Racer Name: " + name + ",  " +
                "Type: " + getClass().getSimpleName() + "}";
    }
}
