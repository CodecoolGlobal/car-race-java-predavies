package com.codecool.car_race;

import com.codecool.car_race.util.RandomHelper;

public class Truck extends Vehicle{

    private State state = State.OPERATIONAL;
    private static final int NORMAL_SPEED = 100;
    private static final int BREAKDOWN_CHANCE = 5;

    private static final int TURNS_NEEDED_TO_FIX_TRUCK = 2;

    private int breakdownTurnsLeft;

    private State nextState() {
        switch (state) {
            case OPERATIONAL:
                if (RandomHelper.eventWithChance(BREAKDOWN_CHANCE)) {
                    breakdownTurnsLeft = TURNS_NEEDED_TO_FIX_TRUCK;
                    return State.BROKEN_DOWN;
                }
                break;
            case BROKEN_DOWN:
                if (breakdownTurnsLeft-- > 0) {
                    return State.BROKEN_DOWN;
                }
                break;
        }
        return State.OPERATIONAL;
    }

    private enum State {
        OPERATIONAL,
        BROKEN_DOWN
    }

    public boolean isBrokenDown() {
        return state != State.OPERATIONAL;
    }
    public Truck() {
        super(NORMAL_SPEED);
    }

    @Override
    public void prepareForLap(Race race) {
        if (isBrokenDown()) actualSpeed = 0;
        else actualSpeed = NORMAL_SPEED;

        state = nextState();
    }

    @Override
    protected String generateName() {
        return Integer.toString(RandomHelper.nextInt(1001));
    }
}
