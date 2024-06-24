package de.dhbw.programming.secondsemester.threads;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TrafficLights extends JFrame {
    private final List<String> lightPhases = List.of("r", "ry", "g", "y");
    private int currentPhase = 0;

    private static final int TL_X_POS = 50;
    private static final int TL_Y_POS = 50;
    private static final int TL_WIDTH = 100;
    private static final int TL_HEIGHT = 300;
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

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
                    TrafficLights.this.switchTLPhase();
                    try {
                        Thread.sleep(1000);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void switchTLPhase() {
        this.currentPhase++;
        if (this.currentPhase >= this.lightPhases.size()) {
            this.currentPhase = 0;
        }
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
        final var currPhase = this.lightPhases.get(this.currentPhase);
        switch (currPhase) {
            case "r" -> {
                g.setColor(Color.RED);
                g.fillOval(TL_X_POS + 11, TL_Y_POS + 11, TL_WIDTH - 22, TL_HEIGHT - 200 - 22);
            }
            case "ry" -> {
                g.setColor(Color.RED);
                g.fillOval(TL_X_POS + 11, TL_Y_POS + 11, TL_WIDTH - 22, TL_HEIGHT - 200 - 22);
                g.setColor(Color.yellow);
                g.fillOval(TL_X_POS + 11, TL_Y_POS + 100 + 11, TL_WIDTH - 22, TL_HEIGHT - 200 - 22);
            }
            case "g" -> {
                g.setColor(Color.green);
                g.fillOval(TL_X_POS + 11, TL_Y_POS + 200 + 11, TL_WIDTH - 22, TL_HEIGHT - 200 - 22);
            }
            case "y" -> {
                g.setColor(Color.yellow);
                g.fillOval(TL_X_POS + 11, TL_Y_POS + 100 + 11, TL_WIDTH - 22, TL_HEIGHT - 200 - 22);
            }
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
