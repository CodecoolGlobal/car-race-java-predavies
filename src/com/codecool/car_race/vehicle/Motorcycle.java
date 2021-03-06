package com.codecool.car_race.vehicle;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

public class Motorcycle extends Vehicle{
    private static int motorcycleNumber = 1;
    private static final int NORMAL_SPEED = 100;

    public Motorcycle() {
        super(NORMAL_SPEED);
    }

    @Override
    public void prepareForLap(Race race) {
        actualSpeed = normalSpeed;
        if (race.isRaining()) {
            int slowDown = RandomHelper.nextInt(5, 50 + 1);
            actualSpeed -= slowDown;
        }
    }

    @Override
    public String generateName() {
        return "Motorcycle " + motorcycleNumber++; // ++variable variable++
    }
}
