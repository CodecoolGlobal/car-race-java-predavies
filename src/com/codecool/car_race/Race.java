package com.codecool.car_race;

import java.util.LinkedList;
import java.util.List;

public class Race {

    private Weather weather = new Weather();

    public boolean isRaining() {
        return weather.isRaining();
    }
    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */
    static final int NUM_OF_LAPS = 50;

    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */
    public void simulateRace() {
        for (int i = 0; i < NUM_OF_LAPS; i++) {
            for (Vehicle vehicle : vehicles) {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
            }

            // change weather and update broken truck status after the movement done
            weather.randomize();
            brokenTruck = getBrokenTruckStatus();
        }
    }

    private boolean getBrokenTruckStatus() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                if (truck.isBrokenDown()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean brokenTruck;

    /**
     * Returns if there is a broken truck on the track based on the brokenTruck field
     * @return true if there are any trucks that are broken down.
     */
    public boolean isYellowFlagActive() {
        return brokenTruck;
    }


    /**
     * Prints the state of all vehicles. Called at the end of the
     * race.
     */
    public void printRaceResults() {
        System.out.println("Race results:");
        vehicles.forEach(System.out::println);
    }

    private final List<Vehicle> vehicles = new LinkedList<>();
    public void registerRacer(Vehicle racer) {
        vehicles.add(racer);
    }
}
