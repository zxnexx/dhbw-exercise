package de.dhbw.java.exercise.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Easter {
    private static final Logger logger = LoggerFactory.getLogger(Easter.class);

    public static void main(final String[] args) {
        while (true) {
            Scanner myObj = new Scanner(System.in);
            int year = myObj.nextInt();

            int a = year % 19;
            int b = year % 4;
            int c = year % 7;
            int k = year / 100;
            int p = (8 * k + 13) / 25;
            int q = k / 4;
            int m = (15 + k - p - q) % 30;
            int n = (4 + k - q) % 7;
            int d = (19 * a + m) % 30;
            int e = (2 * b + 4 * c + 6 * d + n) % 7;
            int easter = (22 + d + e);

            if (easter <= 31) {
                logger.info("Ostern: {}. März", easter);
            } else {
                logger.info("Ostern: {}. April", easter-31);
            }
        }
    }
}
