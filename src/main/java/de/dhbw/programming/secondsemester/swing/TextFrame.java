package de.dhbw.programming.secondsemester.swing;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFrame extends JFrame {
    final static String DEFAULT_PATH_TO_TEXT_FILE = "/home/adschoen/Desktop/";
    int window_width, window_height;

    public TextFrame(final String filename, final int window_width, final int window_height) {
        this.window_width = window_width;
        this.window_height = window_height;
        this.setTitle(filename);

        final var content = new JPanel();

        // TextArea
        final var textAreaPanel = new JPanel();

        final var textArea = new JTextArea();

        String textfileContent;
        try {
            textfileContent = Files.readString(Paths.get(DEFAULT_PATH_TO_TEXT_FILE + filename));
        } catch (final IOException e) {
            textfileContent = "";
            System.out.println(e);
        }
        textArea.setText(textfileContent);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        final var scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(this.window_width, this.window_height));
        textAreaPanel.add(scrollPane);

        content.add(textAreaPanel);

        // Main Frame Dingens
        this.add(content);
        this.setSize(this.window_width, this.window_height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        if (args.length != 3) {
            System.out.printf("Expected 3 arguments [filename, width, height], found %s arguments instead!%n", args.length);
        } else {
            try {
                new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            } catch (final NumberFormatException ignored) {
                System.out.println("Second and Third argument must be INTEGER");
            }
        }
    }
}
