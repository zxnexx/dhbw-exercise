package de.dhbw.programming.firstsemester.classes;

public class Horner {
    private final double[] nums;
    private final String equation;

    public static void main(final String[] args) {
        final var h1 = new Horner(new double[]{1.0, 2.0, 3.0});
        System.out.printf("H1: %s%n", h1);
        h1.getValue(2);
    }

    public Horner(final double[] nums) {
        this.nums = nums;  // nums[0] = n*x^0; nums[1] = n*x^1 etc.
        this.equation = this.convertNumsToEquation(nums);
    }

    private String convertNumsToEquation(final double[] nums) {
        var equation = "";
        if (nums.length == 0) {
            equation = "0";
        } else if (nums.length == 1) {
            equation = String.valueOf(nums[0]);
        } else {
            for (int i = 0; i < nums.length; i++) {
                equation += String.format("%s + x * (", nums[i]);
            }

            // Remove unneeded rest and add parentheses
            equation = equation.substring(0, equation.length() - 8);
            for (int i = 0; i < nums.length - 1; i++) {
                equation += ")";
            }
        }

        return equation;
    }

    public double getValue(final double x) {
        // TODO find solution to parse String to eval
        final var equationValue = this.getEquation();
        // replace all x in equation with double
        equationValue.replaceAll("x", String.valueOf(x));
        System.out.println(equationValue);

        final var split = equationValue.split("\\(");
        for (final var s : split) {
            System.out.println(s);
        }
        return -1.;
    }

    public double[] getNums() {
        return this.nums;
    }

    public String getEquation() {
        return this.equation;
    }

    @Override
    public String toString() {
        return this.getEquation();
    }
}
