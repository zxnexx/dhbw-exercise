package de.dhbw.programming.firstsemester.controllstructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LeapYear {
    private static final Logger logger = LoggerFactory.getLogger(LeapYear.class);
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);

        System.out.print("Welches Jahr soll auf Schaltjahr geprüft werden? ");
        final int year = scanner.nextInt();

        if (checkLeapYear(year)) {
            System.out.println(year + " ist ein Schaltjahr");
        } else {
            System.out.println(year + " ist kein Schaltjahr");
        }

    }

    private static boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return (year % 400 == 0);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
