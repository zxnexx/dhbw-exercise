package de.dhbw.programming.firstsemester.datatypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Round {
    private static final Logger logger = LoggerFactory.getLogger(Round.class);

    public static void main(final String[] args) {
        final var pi = 3.1415926;
        final var e = 2.7182818;

        final var piInt = (int) Math.round(pi);
        final var negPiInt = (int) Math.round(-pi);
        final var eInt = (int) Math.round(e);
        final var negEInt = (int) Math.round(-e);


        logger.info("Pi integer: {}", piInt);
        logger.info("Negative Pi integer: {}", negPiInt);
        logger.info("e integer: {}", eInt);
        logger.info("Negative e integer: {}", negEInt);
    }
}
