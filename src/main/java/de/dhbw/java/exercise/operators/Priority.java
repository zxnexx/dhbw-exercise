package de.dhbw.java.exercise.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Priority {
    private static final Logger logger = LoggerFactory.getLogger(Priority.class);

    @SuppressWarnings("java:S2589")  // Suppress 'Remove Expression which always evaluates to true/false -> intended
    public static void main(final String[] args) {
        logger.info("1: {}" ,(5 / 2 * 2));
        logger.info("2: {}", (9. / 2 * 5));
        boolean a = true;
        boolean b = false;
        boolean c = false;
        //noinspection ConstantValue
        logger.info("3: {}", (a && b || c));
        char ch = 'c';
        //noinspection ConstantValue
        logger.info("4: {}", ('a' + 1 < ch));
        int i = 1;
        int j = 2;
        int k = 3;
        //noinspection ConstantValue
        logger.info("5: {}", (-i - 5 * j >= k + 1));
        i = 1;
        //noinspection ConstantValue
        if (a || (++i == 2)) {
            logger.info("6: {}", i);
        }
        i = 1;
        //noinspection ConstantValue
        if (a || (++i == 2)) {
            logger.info("7: {}", i);
        }
    }

}
