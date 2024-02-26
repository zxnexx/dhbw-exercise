package de.dhbw.programming.exercise.inheritance.periodic;

import java.util.Objects;

public class Metal extends Element {
    private final boolean metalloid;
    private final double conductivity;

    public Metal(final String name, final String symbol, final int ordinal, final char shell, final int phase, final boolean group, final boolean metalloid, final double conductivity) {
        super(name, symbol, ordinal, shell, phase, group);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }

    public boolean isMetalloid() {
        return this.metalloid;
    }

    public double getConductivity() {
        return this.conductivity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final Metal metal = (Metal) o;
        return this.metalloid == metal.metalloid && Double.compare(this.conductivity, metal.conductivity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.metalloid, this.conductivity);
    }

    @Override
    public String toString() {
        return "Metal{" +
                "metalloid=" + this.metalloid +
                ", conductivity=" + this.conductivity +
                "} " + super.toString();
    }
}
