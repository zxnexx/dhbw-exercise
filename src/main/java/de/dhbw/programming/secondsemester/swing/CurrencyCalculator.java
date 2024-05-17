package de.dhbw.programming.secondsemester.swing;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator extends JFrame {
    public CurrencyCalculator() {
        this.setTitle("Currency Calculator");
        final var content = new JPanel();

        // Textfield
        final var textfieldPanel = new JPanel();
        final var textfield = new JTextField("Please enter amount to convert!", 32);

        textfieldPanel.add(textfield);

        content.add(textfieldPanel, BorderLayout.NORTH);

        // Buttons
        final var buttonPanelEurUsd = new JPanel();
        final var buttonPanelUsdEur = new JPanel();
        final var buttonPanelCancel = new JPanel();

        final var buttonEurUsd = new JButton("EUR -> USD");
        final var buttonUsdEur = new JButton("USD -> EUR");
        final var buttonCancel = new JButton("Cancel");


        buttonPanelEurUsd.add(buttonEurUsd, BorderLayout.SOUTH);
        buttonPanelUsdEur.add(buttonUsdEur, BorderLayout.SOUTH);
        buttonPanelCancel.add(buttonCancel, BorderLayout.SOUTH);

        content.add(buttonPanelEurUsd);
        content.add(buttonPanelUsdEur);
        content.add(buttonPanelCancel);

        // Main Frame Dingens
        this.add(content);
        this.setSize(600, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        new CurrencyCalculator();
    }
}
