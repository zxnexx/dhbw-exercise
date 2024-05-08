package de.dhbw.programming.firstsemester.methods;

import java.util.Scanner;

public class Fibonacci {
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);
        System.out.println("How many fibonacci-Numbers to calculate: ");
        final var n = scanner.nextInt();

        final var res = fib(n);
        System.out.println(res);
    }

    private static int fib(final int n) {
        return -1;
    }
}
