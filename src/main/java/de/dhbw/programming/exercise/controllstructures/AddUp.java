package de.dhbw.programming.exercise.controllstructures;

import java.util.Scanner;

@SuppressWarnings("java:S106")
public class AddUp {
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);
        whileLoop(scanner);
        doWhileLoop(scanner);
    }

    public static void whileLoop(final Scanner scanner) {
        var sum = 0;
        var running = true;
        System.out.println("Zahl eingeben (<0 fuer Abbruch): ");
        while (running) {
            final var input = scanner.nextInt();
            if (input < 0) {
                running = false;
            } else {
                sum += input;
            }
        }
        final var message = String.format("Summe: %s%n", sum);
        System.out.println(message);
    }

    public static void doWhileLoop(final Scanner scanner) {
        var sum = 0;
        System.out.println("Zahl eingeben (<0 fuer Abbruch): ");
        var input = 0;
        do {
            input = scanner.nextInt();
            if (input >= 0) {
                sum += input;
            }
        } while (input >= 0);
        final var message = String.format("Summe: %s%n", sum);
        System.out.println(message);
    }
}
