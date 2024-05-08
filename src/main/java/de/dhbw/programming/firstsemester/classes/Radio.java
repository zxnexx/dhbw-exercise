package de.dhbw.programming.firstsemester.classes;

public class Radio {
    public static void main(final String[] args) {

    }

    private boolean on;
    private int volume;
    private final double frequency;

    public Radio() {
        this.on = false;
        this.volume = 0;
        this.frequency = 85.0;
    }

    public Radio(final boolean on, final int volume, final double frequency) {
        if (volume >= 0 && volume <= 10) {
            this.volume = volume;
        } else {
            throw new IllegalArgumentException(String.format("Value '%s' Volume not allowed!", volume));
        }
        if (frequency >= 85.0 && frequency <= 110.0) {
            this.frequency = frequency;
        } else {
            throw new IllegalArgumentException(String.format("Value '%s' Frequency not allowed!", frequency));
        }
        this.on = on;
    }

    public void incVolume() {
        if (this.volume < 10 && this.on) {
            this.volume++;
        }
    }

    public void decVolume() {
        if (this.volume > 0 && this.on) {
            this.volume--;
        }
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }
}
