package de.dhbw.programming.exercise.arrays.arrays2;

public class Pascal {
    private static final int SIZE = 9;

    public static void main(final String[] args) {
        final var triangle = new int[SIZE][SIZE];
        triangle[0][0] = 1;

        for (int row = 1; row < SIZE; row++) {
            for (int col = 0; col < row; col++) {
                if (col == 0) {
                    // element is on left end of triangle -> only 1 parent with index row-1, 0
                    triangle[row][col] = triangle[row - 1][0];
                } else if (col == row) {
                    // element is on right end of triangle -> only 1 parent with index row-1, row
                    triangle[row][col] = triangle[row - 1][col + 1];
                } else {
                    // take both parents
                    System.out.printf("Row: %s; Col: %s%n", row, col);
                    triangle[row][col] = triangle[row - 1][col] + triangle[row - 1][col];
                }
            }
        }
        printMatrix(triangle);


    }

    private static void printMatrix(final int[][] matrix) {
        for (final int[] x : matrix) {
            System.out.print(" ");
            for (final int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
