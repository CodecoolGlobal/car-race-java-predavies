package com.codecool.car_race.vehicle;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

public class Car extends Vehicle{

    protected final int YELLOW_FLAG_SPEED = 75;

    private static final String[] POSSIBLE_NAMES = {
            "Driver ",
            "Idiot ",
            "Slow ",
            "Fast ",
            "Raging ",
            "Wizard ",
            "Lizard ",
            "Bitch ",
            "Fucker ",
            "Punk ",
            "Shithead ",
            "Walker ",
            "Devil ",
            "Angel ",
            "Crime ",
            "Boi "
    };

    public Car() {
        super(calculateNormalSpeed());
    }

    private static int calculateNormalSpeed() {
        return RandomHelper.nextInt(80, 110+1);
    }

    @Override
    public void prepareForLap(Race race) {
        if (race.isYellowFlag()) {
            actualSpeed = YELLOW_FLAG_SPEED;
        } else
            actualSpeed = normalSpeed;
    }

    @Override
    public String generateName() {
        String firstName = RandomHelper.chooseOne(POSSIBLE_NAMES);
        String lastName = RandomHelper.chooseOne(POSSIBLE_NAMES);
        return firstName + lastName;
    }
}
