package de.dhbw.programming.exercise.inheritance.vehicles;

public class Car extends Vehicle {
    private static final int AMOUNT_TYRES = 4;
    private static final double V_MAX = 144.0;

    protected Car() {
        super(AMOUNT_TYRES, V_MAX);
    }

    protected Car(final double vMax) {
        super(AMOUNT_TYRES, vMax);
    }

    public Car(final double currentSpeed, final double vMax) {
        super(AMOUNT_TYRES, vMax);
        this.setSpeed(currentSpeed);
    }
}
