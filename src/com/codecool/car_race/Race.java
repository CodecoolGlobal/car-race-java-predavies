package com.codecool.car_race;

import java.util.LinkedList;
import java.util.List;

public class Race {

    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */
    public void simulateRace() {
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
