package de.dhbw.programming.exercise.classes;

import java.util.Objects;

public class Polynomial {
    private final double a;
    private final double b;
    private final double c;

    public static void main(final String[] args) {
        final var p1 = new Polynomial(4, -8, 2);
        final var p2 = new Polynomial(1, -6, 9);

        System.out.printf("P1: %s%n", p1);
        System.out.printf("P2: %s%n", p2);

        final var fv1 = p1.functionValue(2.0);
        System.out.printf("-----%np1.functionValue(2.0): %s%n", fv1);
        final var fv2 = p2.functionValue(3.5);
        System.out.printf("-----%np2.functionValue(3.5): %s%n", fv2);

        final var p3 = p1.addPolynomial(p2);
        System.out.printf("-----%np1 + p2 = p3%np1: %s%np2: %s%np3: %s%n",
                p1, p2, p3);

        final var p4 = p1.subPolynomial(p3);
        System.out.printf("-----%np1 - p3 = p4%np1: %s%np3: %s%np4: %s%n",
                p1, p3, p4);

        final var p5 = p4.scalarPolynomial(-3.0);
        System.out.printf("-----%np4 * -3.0 = p5%np4: %s%n *%s%np5: %s%n",
                p4, -3.0, p5);

        final var z1 = p1.zeroPoint();
        final var z2 = p2.zeroPoint();
        final var z3 = p3.zeroPoint();
        final var z4 = p4.zeroPoint();
        final var z5 = p5.zeroPoint();

        System.out.printf("-----%nZero Points for p1:%n%s%n", p1);
        printZeroPoints(z1);
        System.out.printf("-----%nZero Points for p2:%n%s%n", p2);
        printZeroPoints(z2);
        System.out.printf("-----%nZero Points for p3:%n%s%n", p3);
        printZeroPoints(z3);
        System.out.printf("-----%nZero Points for p4:%n%s%n", p4);
        printZeroPoints(z4);
        System.out.printf("-----%nZero Points for p5:%n%s%n", p5);
        printZeroPoints(z5);
    }

    private static void printZeroPoints(final double[] zeroPoints) {
        if (zeroPoints.length == 0) {
            System.out.println("No Zero Points");
        } else if (zeroPoints.length == 1) {
            System.out.printf("x1 = %s%n", zeroPoints[0]);
        } else {
            System.out.printf("x1 = %s%nx2 = %s%n", zeroPoints[0], zeroPoints[1]);
        }
    }

    public Polynomial(final double a, final double b, final double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double functionValue(final double x) {
        return this.getA() * Math.pow(x, 2) + this.getB() * x + this.getC();
    }

    public Polynomial addPolynomial(final Polynomial polynomial2) {
        return new Polynomial(
                this.getA() + polynomial2.getA(),
                this.getB() + polynomial2.getB(),
                this.getC() + polynomial2.getC()
        );
    }

    public Polynomial subPolynomial(final Polynomial polynomial2) {
        return new Polynomial(
                this.getA() - polynomial2.getA(),
                this.getB() - polynomial2.getB(),
                this.getC() - polynomial2.getC()
        );
    }

    public Polynomial scalarPolynomial(final double scalar) {
        return new Polynomial(
                this.getA() * scalar,
                this.getB() * scalar,
                this.getC() * scalar
        );
    }

    public double[] zeroPoint() {
        final var z1 = (-this.b + this.discriminant(this.getA(), this.getB(), this.getC())) / (2 * this.a);
        final var z2 = (-this.b - this.discriminant(this.getA(), this.getB(), this.getC())) / (2 * this.a);

        if (Double.isNaN(z1) && Double.isNaN(z2)) {
            return new double[]{};
        } else if (Double.isNaN(z1)) {
            return new double[]{z2};
        } else if (Double.isNaN(z2)) {
            return new double[]{z1};
        } else if (z1 == z2) {
            return new double[]{z1};
        } else {
            return new double[]{z1, z2};
        }
    }

    private double discriminant(final double a, final double b, final double c) {
        return Math.sqrt(Math.pow(b, 2) - 4 * a * c);

    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Polynomial that = (Polynomial) o;
        return this.a == that.a && this.b == that.b && this.c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c);
    }

    @Override
    public String toString() {
        return String.format(
                "%sx^2 + %sx + %s",
                this.a, this.b, this.c
        );
    }
}
