package de.dhbw.programming.exercise.arrays.arrays1;

public class Fibonacci {
    private static final int N = 50;

    public static void main(final String[] args) {
        final var res = new double[N];

        res[0] = 1.0;
        res[1] = 1.0;

        for (int i = 2; i < N; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        for (int i = 0; i < N; i++) {
            System.out.printf("%s: %s%n", i, res[i]);
        }
    }
}
