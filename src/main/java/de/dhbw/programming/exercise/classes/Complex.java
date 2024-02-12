package de.dhbw.programming.exercise.classes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Complex {
    private final double real;
    private final double imag;

    public static void main(final String[] args) {
        final var random = new Random();
        final var c1 = new Complex(2.0, 1.0);
        final var c2 = new Complex(5.5, 2.5);

        System.out.printf("C1: %s%n", c1);

        final var r1 = c1.getReal();
        final var i1 = c1.getImag();

        System.out.printf("R1: %s%n", r1);
        System.out.printf("I1: %s%n", i1);

        System.out.printf("C2: %s%n", c2);

        final var c3 = c1.addComplex(c2);
        System.out.printf("-----%nc1 + c2 = c3%nc1: %s%nc2: %s%nc3%s%n",
                c1, c2, c3);

        final var c4 = c3.subComplex(c2);
        System.out.printf("-----%nc3 - c2 = c3%nc3: %s%nc2: %s%nc4%s%n",
                c3, c2, c4);

        final var c5 = c4.multComplex(c2);
        System.out.printf("-----%nc4 * c2 = c5%nc4: %s%nc2: %s%nc5: %s%n",
                c4, c2, c5);

        final var c6 = c5.divComplex(c3);
        System.out.printf("-----%nc5 / c3 = c6%nc5: %s%nc3: %s%nc6: %s%n",
                c5, c3, c6);

        final var m1 = c1.getMagnitude();
        final var m2 = c2.getMagnitude();
        System.out.printf("-----%nc1.getMagnitude(): %s%nc2.getMagnitude(): %s%n",
                m1, m2);

        final var l1 = c1.isLess(c2);
        System.out.printf("c1.isLess(c2): %s%n", l1);

        final Complex[] complexes = new Complex[10];
        for (int i = 0; i < 10; i++) {
            complexes[i] = new Complex(random.nextDouble(-10.0, 10.0), random.nextDouble(-10.0, 10.0));
        }

        System.out.println("-----%nUnordered%n");
        for (final var complex : complexes) {
            final var m = complex.getMagnitude();
            System.out.printf("%s  Magnitude: %s%n", complex, m);
        }

        Arrays.sort(complexes, new Comparator<Complex>() {
            @Override
            public int compare(final Complex o1, final Complex o2) {
                if (o1.isLess(o2)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        System.out.printf("-----%nOrdered%n");
        for (final var complex : complexes) {
            final var m = complex.getMagnitude();
            System.out.printf("%s  Magnitude: %s%n", complex, m);
        }
    }

    public Complex(final double real, final double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex addComplex(final Complex complex2) {
        return new Complex(this.getReal() + complex2.getReal(), this.getImag() + complex2.getImag());
    }

    public Complex subComplex(final Complex complex2) {
        return new Complex(this.getReal() - complex2.getReal(), this.getImag() - complex2.getImag());
    }

    public Complex multComplex(final Complex complex2) {
        return new Complex(
                this.getReal() * complex2.getReal() - this.getImag() * complex2.getImag(),
                this.getReal() * complex2.getImag() + this.getImag() * complex2.getReal()
        );
    }

    public Complex divComplex(final Complex complex2) {
        final var denominator = Math.pow(complex2.getReal(), 2) + Math.pow(complex2.getImag(), 2);
        return new Complex(
                (this.getReal() * complex2.getReal() + this.getImag() + complex2.getImag()) / denominator,
                (this.getImag() * complex2.getReal() - this.getReal() * complex2.getImag()) / denominator
        );
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    public boolean isLess(final Complex complex2) {
        return this.getMagnitude() < complex2.getMagnitude();
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Complex complex = (Complex) o;
        return Double.compare(this.real, complex.real) == 0 && Double.compare(this.imag, complex.imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.real, this.imag);
    }

    @Override
    public String toString() {
        return String.format(
                "Complex %s + %si", this.real, this.imag
        );
    }
}
