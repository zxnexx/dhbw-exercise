package de.dhbw.programming.exercise.inheritance.vehicles;

public class RacingCar extends Car {
    private static final double V_MAX = 220.0;

    public RacingCar(final double currentSpeed) {
        super(V_MAX);
        this.setSpeed(currentSpeed);
    }
}
