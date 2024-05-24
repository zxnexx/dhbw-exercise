package de.dhbw.programming.secondsemester.swing;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

        buttonEurUsd.addActionListener(e -> this.buttonEurUsdPressed(textfield.getText()));
        buttonUsdEur.addActionListener(e -> this.buttonUsdEurPressed(textfield.getText()));
        buttonCancel.addActionListener(e -> this.buttonCancelPressed());

        content.add(buttonPanelEurUsd);
        content.add(buttonPanelUsdEur);
        content.add(buttonPanelCancel);

        // Main Frame Dingens
        this.add(content);
        this.setSize(600, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    void showResult(final double result) {
        JOptionPane.showMessageDialog(null, String.valueOf(result), "Result", JOptionPane.ERROR_MESSAGE);
    }

    void buttonEurUsdPressed(final String value) {
        final var res = BigDecimal.valueOf(Double.parseDouble(value) * 1.09).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.showResult(res);
    }

    void buttonUsdEurPressed(final String value) {
        final var res = BigDecimal.valueOf(Double.parseDouble(value) / 1.09).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.showResult(res);
    }

    void buttonCancelPressed() {
        System.exit(0);
    }

    public static void main(final String[] args) {
        new CurrencyCalculator();
    }
}
