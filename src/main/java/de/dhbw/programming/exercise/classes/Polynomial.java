package de.dhbw.programming.exercise.classes;

import java.util.Objects;

public class Polynomial {
    private final double a;
    private final double b;
    private final double c;

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
        // TODO catch math exception if negative sqrt, because then only 1 or 0 solutions
        final var z1 = (-this.b + this.discriminant(this.getA(), this.getB(), this.getC())) / (2 * this.a);
        final var z2 = (-this.b - this.discriminant(this.getA(), this.getB(), this.getC())) / (2 * this.a);
        return new double[]{z1, z2};
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
