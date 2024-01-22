package de.dhbw.programming.exercise.controllstructures;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperatureTable {
    public static void main(final String[] args) {
        System.out.print("""
                Fahrenheit  | Celsius
                ---------------------
                """);

        for (int f = 0; f < 301; f++) {
            var bdc = new BigDecimal(Double.toString((5.0 / 9.0) * (f - 32)));
            bdc = bdc.setScale(1, RoundingMode.HALF_UP);
            final var c = bdc.doubleValue();

            String fFiller;
            if (f < 10) {
                fFiller = "  ";
            } else if (f < 100) {
                fFiller = " ";
            } else {
                fFiller = "";
            }

            String cFiller;
            if (c > -100 && c <= -10) {
                cFiller = "";
            } else if (c < 0 && c > -10) {
                cFiller = " ";
            } else if (c >= 0 && c < 10) {
                cFiller = "  ";
            } else if (c >= 0 && c < 100) {
                cFiller = " ";
            } else {
                cFiller = "";
            }

            System.out.println(fFiller + f + "         | " + cFiller + c);
        }
    }
}
