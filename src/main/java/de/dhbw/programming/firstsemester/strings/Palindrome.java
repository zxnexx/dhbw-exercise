package de.dhbw.programming.firstsemester.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);

        System.out.println("Please enter a word: ");
        final String query = scanner.next();

        final StringBuilder queryBuilder = new StringBuilder(query);
        final String reverseQuery = queryBuilder.reverse().toString();

        System.out.printf("Reversed: %s%n", reverseQuery);

        if (query.equalsIgnoreCase(reverseQuery)) {
            System.out.printf("%s is a palindrome!%n", query);
        } else {
            System.out.printf("%s is not a palindrome!%n", query);
        }
    }
}
