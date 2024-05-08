package de.dhbw.programming.secondsemester.swing;

import javax.swing.*;
import java.awt.*;

public class ComponentFrame extends JFrame {
    public ComponentFrame() throws HeadlessException {
        this.setTitle("Exercise 1");
        final var content = new JPanel();

        // Textfield
        final var textfieldPanel = new JPanel();
        final var textfieldLabel = new JLabel("A Textfield:");
        final var textfield = new JTextField("", 16);

        textfieldPanel.add(textfieldLabel);
        textfieldPanel.add(textfield);

        content.add(textfieldPanel);

        // Password
        final var passwordPanel = new JPanel();

        final var passwordLabel = new JLabel("Password: ");
        final var passwordField = new JPasswordField("", 16);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        content.add(passwordPanel);

        // Button
        final var buttonPanel = new JPanel();

        final var button = new JButton("pls press me");

        button.setToolTipText("Please press this button");

        buttonPanel.add(button);

        content.add(buttonPanel);

        // ToggleButton
        final var toggleButtonPanel = new JPanel();

        final var toggleButton = new JToggleButton("pls toggle me");

        toggleButtonPanel.add(toggleButton);

        content.add(toggleButtonPanel);

        // Checkboxes
        final var checkboxPanel = new JPanel();

        final var checkboxLabel = new JLabel("Check this");
        final var c1 = new Checkbox("Uno");
        final var c2 = new Checkbox("Dos");

        checkboxPanel.add(c1);
        checkboxPanel.add(c2);

        content.add(checkboxLabel);
        content.add(c1);
        content.add(c2);

        // Combobox
        final var comboboxPanel = new JPanel();

        final var comboboxQuestion = new JLabel("Best Color?");
        final var comboboxArray = new String[]{"Red", "Green", "Blue"};
        final var comboBoxSelection = new JComboBox(comboboxArray);

        comboboxPanel.add(comboboxQuestion);
        comboboxPanel.add(comboBoxSelection);

        content.add(comboboxPanel);

        // RadioButtons
        final var radioPanel = new JPanel();

        final var radioLabel = new JLabel("B-B-B-Boxes");
        radioPanel.add(radioLabel);

        final var r1 = new JRadioButton("R1");
        final var r2 = new JRadioButton("R2");
        final var r3 = new JRadioButton("R3");
        final ButtonGroup rGroup = new ButtonGroup();

        rGroup.add(r1);
        rGroup.add(r2);
        rGroup.add(r3);

        radioPanel.add(r1);
        radioPanel.add(r2);
        radioPanel.add(r3);

        content.add(radioPanel);

        // Main Frame Dingens
        this.add(content);
        this.setSize(600, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        new ComponentFrame();
    }
}
