package de.dhbw.programming.firstsemester.inheritance.vehicles;

public class Bicycle extends Vehicle {
    private static final int AMOUNT_TYRES = 2;
    private static final double V_MAX = 30.0;

    public Bicycle(final double currentSpeed) {
        super(AMOUNT_TYRES, V_MAX);
        this.setSpeed(currentSpeed);
    }
}
