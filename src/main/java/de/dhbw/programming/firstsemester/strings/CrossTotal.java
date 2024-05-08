package de.dhbw.programming.firstsemester.strings;

import java.util.Scanner;

public class CrossTotal {
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);

        System.out.print("Please enter int for cross total: ");
        final String query = scanner.next();
        var res = 0;

        final char[] numCharArray = query.toCharArray();
        for (final char c : numCharArray) {
            res += c - '0';  // idk
        }
        System.out.printf("Cross Total: %d", res);
    }
}
