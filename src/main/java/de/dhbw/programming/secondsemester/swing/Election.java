package de.dhbw.programming.secondsemester.swing;

import javax.swing.*;
import java.awt.*;

public class Election {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new JFrame("Election Results");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.add(new BarChartPanel());
            frame.setVisible(true);
        });
    }
}

class BarChartPanel extends JPanel {
    // Election results data
    private final String[] parties = {"SPD", "UNION", "GRUENE", "FDP", "AFD", "LINKE", "SSW", "OTHERS"};
    private final double[] percentages = {25.7, 24.1, 14.8, 11.5, 10.3, 4.9, 0.1, 0.8};
    private final Color[] colors = {
            Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
            Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.GRAY
    };

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final int width = this.getWidth() - this.parties.length * 10;
        final int height = this.getHeight();
        final int padding = 40;
        final int barWidth = (width - 2 * padding) / this.parties.length;
        final int maxBarHeight = height - 2 * padding;

        // Find the maximum percentage for scaling
        double maxPercentage = 0;
        for (final double percentage : this.percentages) {
            if (percentage > maxPercentage) {
                maxPercentage = percentage;
            }
        }
        if (maxPercentage <= 0) {
            throw new IllegalArgumentException("maxPercentage cannot be leq than 0");
        }

        // Draw the bars
        for (int i = 0; i < this.parties.length; i++) {
            final int barHeight = (int) ((this.percentages[i] / maxPercentage) * maxBarHeight);
            final int x = padding + i * barWidth + i * 10;
            final int y = height - padding - barHeight;

            g.setColor(this.colors[i]);
            g.fillRect(x, y, barWidth, barHeight);

            // Draw the percentage text
            g.setColor(Color.BLACK);
            final String percentageText = String.format("%.1f%%", this.percentages[i]);
            final int textWidth = g.getFontMetrics().stringWidth(percentageText);
            g.drawString(percentageText, x + (barWidth - textWidth) / 2, y - 5);

            // Draw the party name
            final String partyName = this.parties[i];
            final int partyNameWidth = g.getFontMetrics().stringWidth(partyName);
            g.drawString(partyName, x + (barWidth - partyNameWidth) / 2, height - padding + 15);
        }
    }
}
