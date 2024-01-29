package de.dhbw.programming.exercise.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Eratostenes {
    private static final int N = 100;

    public static void main(final String[] args) {
        final List<Integer> sieves = new ArrayList<>();
        final List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < N + 1; i++) {
            sieves.add(i);
        }

        while (!sieves.isEmpty()) {
            final var min = Collections.min(sieves);
            primes.add(min);

            final List<Integer> nToRemove = new ArrayList<>();
            for (final int n : sieves) {
                if (n % min == 0 && sieves.contains(n)) {
                    nToRemove.add(n);
                }
            }
            sieves.removeAll(nToRemove);
        }
        System.out.printf("%n%n%n%s%n", primes);
    }
}
