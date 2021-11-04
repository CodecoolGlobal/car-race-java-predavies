package com.codecool.car_race.vehicle;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

import javax.swing.plaf.nimbus.State;

public class Truck extends Vehicle{
    private static final int BREAKDOWN_CHANCE = 5;
    private static final int TURNS_NEEDED_TO_FIX = 2;
    private int brokenDownTurnsLeft;

    private static final int NORMAL_SPEED = 100;
    private State state = State.OPERATIONAL;

    private enum State {
        OPERATIONAL,
        BROKEN_DOWN;
    }

    private State nextState() { // Nem teljesen látom át hogy itt mi történik
        switch (state) {
            case OPERATIONAL:
                if (RandomHelper.eventWithChance(BREAKDOWN_CHANCE)) {
                    brokenDownTurnsLeft = TURNS_NEEDED_TO_FIX;
                    return State.BROKEN_DOWN;
                }
                break;
            case BROKEN_DOWN:
                if (brokenDownTurnsLeft-- > 0) {
                    return State.BROKEN_DOWN;
                }
                break;
        }
        return State.OPERATIONAL;
    }

    public boolean isBrokenDown() {
        return state != State.OPERATIONAL;
    }

    public Truck() {
        super(NORMAL_SPEED);
    }

    @Override
    public void prepareForLap(Race race) {
        if (isBrokenDown()) {
            actualSpeed = 0;
        } else
        actualSpeed = NORMAL_SPEED;
    }

    @Override
    public String generateName() {
        return Integer.toString(RandomHelper.nextInt(1001));
    }

}
