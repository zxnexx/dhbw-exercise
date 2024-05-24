package de.dhbw.programming.secondsemester.swing;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextFileViewer {
    private static final JFrame jframe1 = new JFrame("frame1");
    private static final JFrame jframe2 = new JFrame("frame2");
    private static String SELECTED_FILE_ABSOLUTE_PATH = "";

    public static void main(final String[] args) throws IOException {
        final JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(final File f) {
                return f.isDirectory() ||
                        f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        final int state = fc.showOpenDialog(null); // Varianten öffnen / zeigen
// int state = fc.showSaveDialog(null); // Variante speichern
// int state = fc.showDialog(null, "Delete"); // freie Variante
        if (state == JFileChooser.APPROVE_OPTION) {
            SELECTED_FILE_ABSOLUTE_PATH = fc.getSelectedFile().getAbsolutePath();
            final var textFileViewer = new TextFileViewer();
            textFileViewer.displayTextFileGridLayout(SELECTED_FILE_ABSOLUTE_PATH);
            textFileViewer.displayTextFileJTextArea(SELECTED_FILE_ABSOLUTE_PATH);
        } else {
            System.out.println("No selection");
        }
    }

    private void displayTextFileGridLayout(final String path) throws IOException {
        final var textFrame = new JFrame("jframe1");
        textFrame.setLayout(new GridLayout(10, 1));

        try (final Stream<String> lines = Files.lines(Path.of(path))) {
            final var stringRows = lines.limit(10).toList();
            for (String s : stringRows) {
                s = s.replaceAll("\\R", "");
                final var textLabel = new JLabel(s);
                textFrame.add(textLabel);
            }
        }

        // Main Frame Dingens
        textFrame.setSize(300, 600);
        textFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textFrame.setVisible(true);
    }

    private void displayTextFileJTextArea(final String path) {
        final var content = new JPanel();
        final var textAreaPanel = new JPanel();
        final var textArea = new JTextArea();

        String textfileContent;
        try {
            textfileContent = Files.readString(Paths.get(path));
        } catch (final IOException e) {
            textfileContent = "";
            System.out.println(e);
        }
        textArea.setText(textfileContent);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        final var scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 600));
        textAreaPanel.add(scrollPane);

        content.add(textAreaPanel);

        // Main Frame Dingens
        jframe2.add(content);
        jframe2.setSize(300, 600);
        jframe2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe2.setVisible(true);
    }
}
