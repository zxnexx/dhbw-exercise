package de.dhbw.java.exercise.datatypes;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class ShortValue {
    private static final Logger logger = LoggerFactory.getLogger(Slf4j.class);
    public static void main(final String[] args) {
        short shortValue = 32767;
        String shortString = String.valueOf(shortValue);
        logger.info(shortString);

        shortValue++;
        shortString = String.valueOf(shortValue);
        logger.info(shortString);
    }

}
