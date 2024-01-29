package de.dhbw.programming.exercise.controllstructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class QuadraticFormula {
    private static final Logger logger = LoggerFactory.getLogger(QuadraticFormula.class);

    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);

        final double a = scanner.nextDouble();
        final double b = scanner.nextDouble();
        final double c = scanner.nextDouble();

        if (a == 0 ) {
            if (b == 0) {
                logger.info("Die Gleichung ist degeneriert");
            } else {
                final var x1 = -(c/b);
                logger.info("x1 = {}", x1);
            }
        } else {  // a != 0
            final var d = Math.pow(b, 2) - (4 * a * c);
            if (d >= 0) {
                final var x1 = (-b + Math.sqrt(d)) / (2 * a);
                final var x2 = (-b - Math.sqrt(d)) / (2 * a);
                logger.info("x1 = {}, x2 = {}", x1, x2);
            } else {
                logger.info("Die Lösung ist konjugiert komplex");
            }
        }
    }
}
