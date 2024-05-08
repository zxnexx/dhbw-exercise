package de.dhbw.programming.firstsemester.methods;

import java.util.Scanner;

public class Exponentiation {
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);

        System.out.println("Please enter base: ");
        final double base = scanner.nextDouble();
        System.out.println("Please enter integer exponent: ");
        final int exponent = scanner.nextInt();

        final var result = xPowerN(base, exponent);

        System.out.printf("%s^%s = %s", base, exponent, result);
    }

    private static double xPowerN(final double x, final int n) {
        if (n == 0) {
            return 1.0;
        } else {
            return x * xPowerN(x, n - 1);
        }
    }
}
