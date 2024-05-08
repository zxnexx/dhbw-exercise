package de.dhbw.programming.exercise.inheritance.vehicles;

import java.util.Objects;

public class Vehicle {
    private int amountTyres = 0;
    protected double vMax = 0.0;
    protected double speed = 0.0;
    protected double position = 0.0;

    Vehicle(final int amountTyres, final double vMax) {
        this.amountTyres = amountTyres;
        this.vMax = vMax;
    }

    void setSpeed(final double speed) {
        this.speed = Math.min(speed, this.vMax);
    }

    void drive(final double minutes) {
        final var hours = minutes / 60.0;
        this.position += hours * this.speed;  // km/h * h = km
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Vehicle vehicle = (Vehicle) o;
        return this.amountTyres == vehicle.amountTyres && Double.compare(this.vMax, vehicle.vMax) == 0 && Double.compare(this.speed, vehicle.speed) == 0 && Double.compare(this.position, vehicle.position) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.amountTyres, this.vMax, this.speed, this.position);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "amountTyres=" + this.amountTyres +
                ", vMax=" + this.vMax +
                ", speed=" + this.speed +
                ", position=" + this.position +
                '}';
    }
}
