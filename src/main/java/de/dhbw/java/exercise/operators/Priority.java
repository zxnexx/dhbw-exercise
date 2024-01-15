package de.dhbw.java.exercise.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Priority {
    private static final Logger logger = LoggerFactory.getLogger(Priority.class);

    public static void main(final String[] args) {
        logger.info("1: {}" ,(5 / 2 * 2));
        logger.info("2: {}", (9. / 2 * 5));
        boolean a = true;
        boolean b = false;
        boolean c = false;
        logger.info("3: {}", (a && b || c));
        char ch = 'c';
        logger.info("4: {}", ('a' + 1 < ch));
        int i = 1;
        int j = 2;
        int k = 3;
        logger.info("5: {}", (-i - 5 * j >= k + 1));
        i = 1;
        if (a || (++i == 2)) {
            logger.info("6: {}", i);
        }
        i = 1;
        if (a || (++i == 2)) {
            logger.info("7: {}", i);
        }
    }

}
