package de.dhbw.programming.exercise.controllstructures;

import java.text.DecimalFormat;

public class Deers {
    private static final double DEER_STARTING_POPULATION = 200.0;
    private static final double DEER_STOP_POPULATION = 300.0;
    public static void main(final String[] args) {
        var deers = DEER_STARTING_POPULATION;
        var year = 0;

        final var df = new DecimalFormat("#");

        while (deers < DEER_STOP_POPULATION) {
            deers = deers + deers*0.1;
            deers -= 15;
            System.out.println(year++ + ": " + df.format(deers) + " Deers");
        }
    }
}
