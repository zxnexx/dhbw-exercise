package de.dhbw.programming.exercise.controllstructures;

import java.util.Scanner;

public class AddUp {
    public static void main(final String[] args) {
        whileLoop();

        doWhileLoop();
    }
    public static void whileLoop() {
        final var scanner = new Scanner(System.in);
        var res = 0;
        while (true) {
            System.out.println("Zahl eingeben (<0 fuer Abbruch): ");
            final var i = scanner.nextInt();
            if (i < 0) {
                System.out.printf("Summe: %s%n", res);
                break;
            } else {
                res += i;
            }
        }
    }

    public static void doWhileLoop() {
        final var scanner = new Scanner(System.in);
        var res = 0;
        do {
            System.out.println("Zahl eingeben (<0 fuer Abbruch): ");
            final var i = scanner.nextInt();
            if (i < 0) {
                System.out.printf("Summe: %s%n", res);
                break;
            } else {
                res += i;
            }        } while (true);
    }
}
