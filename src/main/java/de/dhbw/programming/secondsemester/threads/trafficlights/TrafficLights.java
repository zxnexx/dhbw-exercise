package de.dhbw.programming.secondsemester.threads.trafficlights;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

    // <editor-fold desc="Getter toString">
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
    // </editor-fold>
}

public class TrafficLights extends JFrame {
    private TrafficLightPhase currentPhase = TrafficLightPhase.RED;

    // <editor-fold desc="JFrame config">
    private static final int TL_X_POS = 50;
    private static final int TL_Y_POS = 50;
    private static final int TL_WIDTH = 100;
    private static final int TL_HEIGHT = 300;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    // </editor-fold>

    public TrafficLights() {
        this.setTitle("Traffic Light");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        new Thread(new Runnable() {
            @SuppressWarnings("java:S2189")
            @Override
            public void run() {
                while (true) {
                    TrafficLights.this.repaint();
                    currentPhase = currentPhase.getNext();
                    try {
                        Thread.sleep(currentPhase.getDuration());
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }).start();
    }

    private void drawTrafficLightFrame(final Graphics g) {
        g.setColor(Color.black);
        g.fillRect(TL_X_POS, TL_Y_POS, TL_WIDTH, TL_HEIGHT);
        g.setColor(Color.WHITE);
        g.fillOval(TL_X_POS + 10, TL_Y_POS + 10, TL_WIDTH - 20, TL_HEIGHT - 200 - 20);
        g.fillOval(TL_X_POS + 10, TL_Y_POS + 100 + 10, TL_WIDTH - 20, TL_HEIGHT - 200 - 20);
        g.fillOval(TL_X_POS + 10, TL_Y_POS + 200 + 10, TL_WIDTH - 20, TL_HEIGHT - 200 - 20);
    }

    private void drawTrafficLightPhase(final Graphics g) {
        if (currentPhase.isRed()) {
            g.setColor(Color.RED);
            g.fillOval(TL_X_POS + 11, TL_Y_POS + 11, TL_WIDTH - 22, TL_HEIGHT - 200 - 22);
        }
        if (currentPhase.isYellow()) {
            g.setColor(Color.yellow);
            g.fillOval(TL_X_POS + 11, TL_Y_POS + 100 + 11, TL_WIDTH - 22, TL_HEIGHT - 200 - 22);
        }
        if (currentPhase.isGreen()) {
            g.setColor(Color.green);
            g.fillOval(TL_X_POS + 11, TL_Y_POS + 200 + 11, TL_WIDTH - 22, TL_HEIGHT - 200 - 22);
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
