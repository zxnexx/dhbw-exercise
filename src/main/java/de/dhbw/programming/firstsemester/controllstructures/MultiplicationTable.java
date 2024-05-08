package de.dhbw.programming.firstsemester.controllstructures;

public class MultiplicationTable {
    public static void main(final String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 10; j++) {
                final var k = i*j;
                System.out.print(k);

                if (k < 10 ) {
                    System.out.print("  ");
                } else {
                    System.out.print(" ");
                }

                if (j == 10) {
                    System.out.print("\n");
                }
            }
        }
    }
}
