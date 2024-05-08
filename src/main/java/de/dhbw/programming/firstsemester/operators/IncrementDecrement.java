package de.dhbw.programming.firstsemester.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncrementDecrement {
    private static final Logger logger = LoggerFactory.getLogger(IncrementDecrement.class);

    public static void main(final String[] args) {
        int i=0;
        int j;
        j = ++i;
        int k = j++ + ++i;
        logger.info("k: {}", k);
        logger.info("*: {}", j++ + ++i);
        logger.info("{}", j++ + ++i);
        int m = j++ * ++i;
        logger.info("m: {}", m);
        int n = --j * --i;
        logger.info("n: {}", n);
        logger.info("i: {}", i);
        logger.info("j: {}", j);
    }
}
