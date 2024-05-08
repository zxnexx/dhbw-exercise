package de.dhbw.programming.firstsemester.arrays.arrays1;

import java.util.Random;

public class StandardDeviation {
    private static final int N = 100;

    public static void main(final String[] args) {
        final var rand = new Random();

        final var nums = new int[N];
        // filling nums with random numbers 0 - 10
        for (int i = 0; i < N; i++) {
            nums[i] = rand.nextInt(11);
        }


        final var mean = calcMean(nums);
        final var standardDeviation = calcStandardDeviation(nums, mean);
        System.out.printf("Mittelwert: %s%n", mean);
        System.out.printf("Standartabweichung: %s%n", standardDeviation);


    }

    private static double calcMean(final int[] nums) {
        var sum = 0;
        for (final int i : nums) {
            sum += i;
        }
        return (double) sum / N;
    }

    private static double calcStandardDeviation(final int[] nums, final double mean) {
        var sum = 0.0;
        for (final int i : nums) {
            sum += Math.pow((i - mean), 2);
        }
        return Math.sqrt(sum / (N - 1));
    }
}
