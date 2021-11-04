package com.codecool.car_race;

public abstract class Vehicle {

    protected Vehicle (int normalSpeed) {
        this.name = generateName();
        this.normalSpeed = normalSpeed;
    }


    protected abstract String generateName();

    protected final String name;
    protected final int normalSpeed;
    protected int actualSpeed;
    protected int distanceTravelled;
    public abstract void prepareForLap(Race race);

    public final void moveForAnHour() {
        distanceTravelled += actualSpeed;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{")
                .append("distance travelled: ")
                .append(distanceTravelled)
                .append(", ")
                .append("type: ")
                .append(getClass().getSimpleName())
                .append(", ")
                .append("name: ")
                .append(name)
                .append("}");
        return sb.toString();
    }
}
