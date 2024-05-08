package de.dhbw.programming.firstsemester.datatypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShortValue {
    private static final Logger logger = LoggerFactory.getLogger(ShortValue.class);

    public static void main(final String[] args) {
        short shortValue = 32767;
        logger.info("{}", shortValue);

        shortValue++;
        logger.info("{}", shortValue);
    }
}
