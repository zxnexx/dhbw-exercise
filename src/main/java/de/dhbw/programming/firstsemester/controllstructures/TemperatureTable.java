package de.dhbw.programming.firstsemester.controllstructures;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperatureTable {
    @SuppressWarnings("java:S106") // suppressed 'Use logger instead of System.out.println()' -> intended
    public static void main(final String[] args) {
        System.out.print("""
                Fahrenheit  | Celsius
                ---------------------
                """);

        for (int f = 0; f < 301; f++) {
            if (f % 20 == 0) {
                // convert to BigDecimal in order to round double to 1 decimal
                var bdc = new BigDecimal(Double.toString((5.0 / 9.0) * (f - 32)));
                bdc = bdc.setScale(1, RoundingMode.HALF_UP);
                final var c = bdc.doubleValue();

                final var fFiller = calculateFiller(f);
                final var cFiller = calculateFiller(c);
                System.out.println(fFiller + f + "         | " + cFiller + c);
            }

        }
    }

    private static String calculateFiller(double value) {
        String filler;
        if (value > -100 && value <= -10) {
            filler = "";
        } else if (value < 0 && value > -10) {
            filler = " ";
        } else if (value >= 0 && value < 10) {
            filler = "  ";
        } else if (value >= 0 && value < 100) {
            filler = " ";
        } else {
            filler = "";
        }
        return filler;
    }
}
