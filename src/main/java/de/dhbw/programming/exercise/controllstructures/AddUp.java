package de.dhbw.programming.exercise.controllstructures;

import java.util.Scanner;

@SuppressWarnings("java:S106")
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
                break;
            } else {
                res += i;
            }
        }
        System.out.printf("Summe: %s%n", res);
    }

    public static void doWhileLoop() {
        final var scanner = new Scanner(System.in);
        var res = 0;
        do {
            System.out.println("Zahl eingeben (<0 fuer Abbruch): ");
            final var i = scanner.nextInt();
            if (i < 0) {
                break;
            } else {
                res += i;
            }
        } while (true);
        System.out.printf("Summe: %s%n", res);
    }
}
