package de.dhbw.programming.secondsemester.threads;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DancingText extends JFrame {
    private final List<Integer> xPositions = new ArrayList<>();
    private final List<Integer> yPositions = new ArrayList<>();
    private final List<Boolean> yPositionUp = new ArrayList<>(); // help me
    private final List<Color> colors = new ArrayList<>();

    private static final int BASE_Y_POSITION = 300;
    private static final int SPEED = 10;
    private static final int AMPLITUDE = 30;

    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 600;

    private static final String TEXT = "WAVEWAVEWAVE";

    public DancingText() {
        this.setFont(new Font("Courier", Font.BOLD, 200));
        this.setTitle("Dancing Text");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for (int i = 0; i < TEXT.length(); i++) {
            this.colors.add(Color.BLUE);
        }

        // Timer for moving characters
        final Timer moveTimer = new Timer(100, e ->

        {
            for (int i = 0; i < TEXT.length(); i++) {
                this.xPositions.add(100 + 100 * i);
                this.yPositions.add(BASE_Y_POSITION + SPEED * i);
                this.yPositionUp.add(true);
            }
            this.repaint();
        });
        moveTimer.start();

        new Thread(new Runnable() {
            @SuppressWarnings("java:S2189")
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < TEXT.length(); i++) {
                        final var currYPos = DancingText.this.yPositions.get(i);
                        // If max height reached (AMPLITUDE), then change direction of movement to down, etc..
                        if (currYPos >= BASE_Y_POSITION + AMPLITUDE) {
                            DancingText.this.yPositionUp.set(i, false);
                        } else if (currYPos <= BASE_Y_POSITION - AMPLITUDE) {
                            DancingText.this.yPositionUp.set(i, true);
                        }
                        // Change Y pos of letter by SPEED
                        if (Boolean.TRUE.equals(DancingText.this.yPositionUp.get(i))) {
                            DancingText.this.yPositions.set(i, currYPos + SPEED);
                        } else {
                            DancingText.this.yPositions.set(i, currYPos - SPEED);
                        }
                        // Set random color
                        DancingText.this.colors.set(i, DancingText.this.getRandomColor());
                    }
                    DancingText.this.repaint();
                    try {
                        Thread.sleep(200); // update every X milliseconds
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private Color getRandomColor() {
        // Only shades of Blue
        final Random random = new Random();
        return new Color(random.nextInt(100), random.nextInt(100), 156 + random.nextInt(100));
    }

    @Override
    public void paint(final Graphics g) {
        super.paint(g);
        for (int i = 0; i < TEXT.length(); i++) {
            g.setColor(this.colors.get(i));
            g.drawString(String.valueOf(TEXT.charAt(i)), this.xPositions.get(i), this.yPositions.get(i));
        }
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new DancingText().setVisible(true));
    }
}
