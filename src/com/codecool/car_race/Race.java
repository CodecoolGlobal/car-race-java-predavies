package com.codecool.car_race;

import com.codecool.car_race.vehicle.Truck;
import com.codecool.car_race.vehicle.Vehicle;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {

    private Weather weather = new Weather();
    private List<Vehicle> vehicles = new ArrayList<>();

    private boolean isBrokenTruck;

    static final int NUM_OF_LAPS = 50;

    public boolean isRaining() {
        return weather.isRaining();
    }

    public boolean isYellowFlag() {
        return isBrokenTruck;
    }

    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */
    public void simulateRace() {
        for (int i = 0; i < NUM_OF_LAPS; i++) {
            for (Vehicle vehicle : vehicles) {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
                weather.randomize();
                isBrokenTruck = getBrokenTruckStatus();
            }
        }
    }

    public boolean getBrokenTruckStatus() {
        return vehicles.parallelStream()
                .filter(v -> v instanceof Truck)
                .map(v -> (Truck)v)
                .anyMatch(Truck::isBrokenDown);
    }

    /**
     * Prints the state of all vehicles. Called at the end of the
     * race.
     */
    public void printRaceResults() {
        vehicles.forEach(System.out::println); // :: in java?
        // How to sort this?
    }

    public void registerRacer(Vehicle racer) {
        vehicles.add(racer);
    }


}
