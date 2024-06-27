package de.dhbw.programming.secondsemester.threads.trafficlights;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

    // <editor-fold desc="Getter, toString()">
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

public class TrafficLights extends JPanel {
    private static final int TL_X_POS = 0;
    private static final int TL_Y_POS = 0;
    private static final int TL_WIDTH = 300;
    private static final int TL_HEIGHT = 900;
    private static final int OVAL_DIAMETER = 200;
    private static final int OVAL_PADDING = 50;

    private TrafficLightPhase currentPhase = TrafficLightPhase.RED;
    private final transient ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public TrafficLights() {
        Runnable changePhaseTask = new Runnable() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    currentPhase = currentPhase.getNext();
                    repaint();
                    scheduler.schedule(this, currentPhase.getDuration(), TimeUnit.MILLISECONDS);
                });
            }
        };

        scheduler.schedule(changePhaseTask, currentPhase.getDuration(), TimeUnit.MILLISECONDS);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTrafficLightFrame(g);
        drawTrafficLightPhase(g);
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
            g.fillOval(TL_X_POS + OVAL_PADDING, TL_Y_POS + OVAL_PADDING, OVAL_DIAMETER, OVAL_DIAMETER);
        }
        if (currentPhase.isYellow()) {
            g.setColor(Color.YELLOW);
            g.fillOval(TL_X_POS + OVAL_PADDING, TL_Y_POS + OVAL_PADDING * 3 + OVAL_DIAMETER, OVAL_DIAMETER, OVAL_DIAMETER);
        }
        if (currentPhase.isGreen()) {
            g.setColor(Color.GREEN);
            g.fillOval(TL_X_POS + OVAL_PADDING, TL_Y_POS + OVAL_PADDING * 5 + OVAL_DIAMETER * 2, OVAL_DIAMETER, OVAL_DIAMETER);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Traffic Light");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 935);
            frame.setLocationRelativeTo(null);
            frame.add(new TrafficLights());
            frame.setVisible(true);
        });
    }
}
