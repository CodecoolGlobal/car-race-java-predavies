package com.codecool.car_race;

public abstract class Vehicle {
    protected Vehicle() {
        this.name = "Vehicle"; //TODO: set name according to specification
        this.normalSpeed = 100; //TODO: set normal speed according to specification
    }
    protected final String name;
    protected final int normalSpeed;
    protected int actualSpeed;
    protected int distanceTravelled;
    public abstract void prepareForLap(Race race);

    public final void moveForAnHour() {
        distanceTravelled += actualSpeed;
    }

}
