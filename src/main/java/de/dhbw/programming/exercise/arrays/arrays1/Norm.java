package de.dhbw.programming.exercise.arrays.arrays1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Norm {
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);

        final List<Integer> comps = new ArrayList<>();
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        final var n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            comps.add(scanner.nextInt());
        }


    }
}
