package de.dhbw.programming.firstsemester.arrays.arrays2;

import java.util.Scanner;

public class MatrixSubtraction {
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);

        System.out.print("Bitte anzahl der Zeilen n eingeben: ");
        final var n = scanner.nextInt();
        System.out.print("Bitte anzahl der Spalten m eingeben: ");
        final var m = scanner.nextInt();

        final var matrixX = new int[m][n];
        final var matrixY = new int[m][n];
        final var matrixZ = new int[m][n];

        for (int i = 0; i < matrixX.length; i++) {
            for (int j = 0; j < matrixX[0].length; j++) {
                matrixX[i][j] = (int) (Math.random() * 100);
                matrixY[i][j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < matrixX.length; i++) {
            for (int j = 0; j < matrixX[0].length; j++) {
                matrixZ[i][j] = matrixX[i][j] - matrixY[i][j];
            }
        }

        System.out.println("X:");
        printMatrix(matrixX);
        System.out.println("Y:");
        printMatrix(matrixY);
        System.out.println("X-Y:");
        printMatrix(matrixZ);
    }

    private static void printMatrix(final int[][] matrix) {

        for (final int[] x : matrix) {
            System.out.print(" ");
            for (final int y : x) {
                var filler = "";
                filler = switch (String.valueOf(y).length()) {
                    case 1 -> "   ";
                    case 2 -> "  ";
                    case 3 -> " ";
                    case 4 -> "";
                    default -> throw new IllegalStateException("Unexpected value: " + String.valueOf(y).length());
                };
                System.out.printf("%s%s ", filler, y);
            }
            System.out.println();
        }
    }
}
