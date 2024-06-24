package de.dhbw.programming.secondsemester.threads.trafficlights;

import javax.swing.*;
import java.awt.*;

enum TrafficLightPhase {
    RED(5000, true, false, false),
    RED_YELLOW(2000, true, true, false),
    GREEN(5000, false, false, true),
    YELLOW(2000, false, true, false);

    private final int duration;
    private final boolean red;
    private final boolean yellow;
    private final boolean green;

    TrafficLightPhase(final int duration, final boolean red, final boolean yellow, final boolean green) {
        this.duration = duration;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
    }

    public TrafficLightPhase getNext() {
        return values()[(ordinal() + 1) % values().length];
    }

    public int getDuration() {
        return duration;
    }

    public boolean isRed() {
        return red;
    }

    public boolean isYellow() {
        return yellow;
    }

    public boolean isGreen() {
        return green;
    }

    @Override
    public String toString() {
        return "TrafficLightPhase{" +
                "duration=" + duration +
                ", red=" + red +
                ", yellow=" + yellow +
                ", green=" + green +
                '}';
    }
}

public class TrafficLights extends JFrame {
    private static final int TL_X_POS = 50;
    private static final int TL_Y_POS = 50;
    private static final int TL_WIDTH = 100;
    private static final int TL_HEIGHT = 300;
    private static final int OVAL_DIAMETER = 80;
    private static final int OVAL_PADDING = 10;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    private TrafficLightPhase currentPhase = TrafficLightPhase.RED;

    public TrafficLights() {
        this.setTitle("Traffic Light");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        new Thread(() -> {
            while (true) {
                SwingUtilities.invokeLater(() -> {
                    currentPhase = currentPhase.getNext();
                    repaint();
                });
                try {
                    Thread.sleep(currentPhase.getDuration());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    private void drawTrafficLightFrame(final Graphics g) {
        g.setColor(Color.black);
        g.fillRect(TL_X_POS, TL_Y_POS, TL_WIDTH, TL_HEIGHT);
        g.setColor(Color.WHITE);
        g.fillOval(TL_X_POS + OVAL_PADDING, TL_Y_POS + OVAL_PADDING, OVAL_DIAMETER, OVAL_DIAMETER);
        g.fillOval(TL_X_POS + OVAL_PADDING, TL_Y_POS + OVAL_PADDING * 3 + OVAL_DIAMETER, OVAL_DIAMETER, OVAL_DIAMETER);
        g.fillOval(TL_X_POS + OVAL_PADDING, TL_Y_POS + OVAL_PADDING * 5 + OVAL_DIAMETER * 2, OVAL_DIAMETER, OVAL_DIAMETER);
    }

    private void drawTrafficLightPhase(final Graphics g) {
        if (currentPhase.isRed()) {
            g.setColor(Color.RED);
            g.fillOval(TL_X_POS + OVAL_PADDING + 1, TL_Y_POS + OVAL_PADDING, OVAL_DIAMETER, OVAL_DIAMETER);
        }
        if (currentPhase.isYellow()) {
            g.setColor(Color.YELLOW);
            g.fillOval(TL_X_POS + OVAL_PADDING + 1, TL_Y_POS + OVAL_PADDING * 3 + OVAL_DIAMETER, OVAL_DIAMETER, OVAL_DIAMETER);
        }
        if (currentPhase.isGreen()) {
            g.setColor(Color.GREEN);
            g.fillOval(TL_X_POS + OVAL_PADDING + 1, TL_Y_POS + OVAL_PADDING * 5 + OVAL_DIAMETER * 2, OVAL_DIAMETER, OVAL_DIAMETER);
        }
    }

    @Override
    public void paint(final Graphics g) {
        super.paint(g);
        this.drawTrafficLightFrame(g);
        this.drawTrafficLightPhase(g);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new TrafficLights().setVisible(true));
    }
}
