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
    private static final int TL_X_POSITION = 0;
    private static final int TL_Y_POSITION = 0;
    private static final int TL_FRAME_WIDTH = 300;
    private static final int TL_FRAME_HEIGHT = 900;
    private static final int TL_DIAMETER = 200;
    private static final int TL_PADDING = 50;

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
        g.fillRect(TL_X_POSITION, TL_Y_POSITION, TL_FRAME_WIDTH, TL_FRAME_HEIGHT);
        g.setColor(Color.WHITE);
        g.fillOval(TL_X_POSITION + TL_PADDING, TL_Y_POSITION + TL_PADDING, TL_DIAMETER, TL_DIAMETER);
        g.fillOval(TL_X_POSITION + TL_PADDING, TL_Y_POSITION + TL_PADDING * 3 + TL_DIAMETER, TL_DIAMETER, TL_DIAMETER);
        g.fillOval(TL_X_POSITION + TL_PADDING, TL_Y_POSITION + TL_PADDING * 5 + TL_DIAMETER * 2, TL_DIAMETER, TL_DIAMETER);
    }

    private void drawTrafficLightPhase(final Graphics g) {
        if (currentPhase.isRed()) {
            drawTrafficLightCircle(g, Color.RED, 1, 0);
        }
        if (currentPhase.isYellow()) {
            drawTrafficLightCircle(g, Color.YELLOW, 3, 1);
        }
        if (currentPhase.isGreen()) {
            drawTrafficLightCircle(g, Color.GREEN, 5, 2);
        }
    }

    private void drawTrafficLightCircle(final Graphics g, final Color color, final int yPosMult, final int diameterMult) {
        g.setColor(color);
        g.fillOval(TL_X_POSITION + TL_PADDING, TL_Y_POSITION + TL_PADDING * yPosMult + TL_DIAMETER * diameterMult, TL_DIAMETER, TL_DIAMETER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Traffic Light");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(300, 935);
            frame.setLocationRelativeTo(null);
            frame.add(new TrafficLights());
            frame.setVisible(true);
        });
    }
}
