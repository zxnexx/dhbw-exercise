package de.dhbw.programming.firstsemester.inheritance.vehicles;

import java.util.Objects;

public class Ambulance extends Car {
    private boolean blueLights;

    public Ambulance(final double currentSpeed, final boolean blueLights) {
        super();
        this.setSpeed(currentSpeed);
        this.blueLights = blueLights;
    }

    public void switchBlueLight() {
        this.blueLights = !this.blueLights;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final Ambulance ambulance = (Ambulance) o;
        return this.blueLights == ambulance.blueLights;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.blueLights);
    }

    @Override
    public String toString() {
        return "Ambulance{" +
                "blueLights=" + this.blueLights +
                ", vMax=" + this.vMax +
                ", speed=" + this.speed +
                ", position=" + this.position +
                '}';
    }
}
