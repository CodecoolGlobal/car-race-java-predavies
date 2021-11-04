package com.codecool.car_race.util;

import java.util.Random;

public class RandomHelper {
    private static final Random RANDOM = new Random();

    public static int nextInt(int upperRange) {
        return RANDOM.nextInt(upperRange);
    }

    public static int nextInt(int lowerRange, int upperRange) {
        return lowerRange + nextInt(upperRange - lowerRange);
    }

    public static String chooseOne(String[] possibleNames) {
        if (possibleNames == null || possibleNames.length < 1) {
            final String message = "Possibilities should be a non-empty array of strings.";
            throw new IllegalArgumentException(); // read about it
        }
        return possibleNames[nextInt(possibleNames.length)];
    }

    public static boolean eventWithChance(int chanceOfRain) {
        return RANDOM.nextInt(100) < chanceOfRain;
    }
}
