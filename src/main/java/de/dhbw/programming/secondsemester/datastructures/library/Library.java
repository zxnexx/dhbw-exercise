package de.dhbw.programming.secondsemester.datastructures.library;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static javax.swing.JOptionPane.showMessageDialog;


public class Library {
    private final List<Book> books = new ArrayList<>();

    public static void main(final String[] args) {
        final var library = new Library();
        // Create the main frame
        final JFrame frame = new JFrame("Book Information");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Create a panel for the labels and text fields
        final JPanel inputPanel = new JPanel(new GridBagLayout());
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Labels and TextFields
        final JLabel titleLabel = new JLabel("Title:");
        final JTextField titleField = new JTextField(20);
        final JLabel authorLabel = new JLabel("Author:");
        final JTextField authorField = new JTextField(20);
        final JLabel yearLabel = new JLabel("Year:");
        final JTextField yearField = new JTextField(20);
        final JLabel publisherLabel = new JLabel("Publisher:");
        final JTextField publisherField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        inputPanel.add(titleLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        inputPanel.add(authorLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(authorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        inputPanel.add(yearLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(yearField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        inputPanel.add(publisherLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        inputPanel.add(publisherField, gbc);

        // Add the input panel to the frame
        frame.add(inputPanel, BorderLayout.CENTER);

        // Create a save button
        final JButton saveButton = new JButton("Save");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(saveButton, gbc);

        // Create a panel for the ordered output buttons
        final JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        final JLabel orderedOutputLabel = new JLabel("Ordered output:");
        outputPanel.add(orderedOutputLabel);

        final JButton titleButton = new JButton("Title");
        final JButton authorButton = new JButton("Author");
        final JButton yearButton = new JButton("Year");
        final JButton publisherButton = new JButton("Publisher");

        outputPanel.add(titleButton);
        outputPanel.add(authorButton);
        outputPanel.add(yearButton);
        outputPanel.add(publisherButton);

        // Add the output panel to the frame
        frame.add(outputPanel, BorderLayout.SOUTH);

        // Action listeners for the save button
        saveButton.addActionListener(e -> {
            try {
                final var stringToWrite = titleField.getText() + ";" + authorField.getText() + ";" + yearField.getText() + ";" + publisherField.getText();
                if (!library.doesStringExistInFile(stringToWrite)) {
                    final BufferedWriter buffWriter = new BufferedWriter(new FileWriter("/home/adschoen/dev-studium/dhbw-exercise/src/main/java/de/dhbw/programming/secondsemester/datastructures/library/books.txt", true));
                    buffWriter.newLine();
                    buffWriter.write(stringToWrite);
                    buffWriter.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            titleField.setText("");
            authorField.setText("");
            yearField.setText("");
            publisherField.setText("");
            library.load_books();
        });

        // Action listeners for the output buttons
        titleButton.addActionListener(e -> {
            final var bList = library.sortBy("title");
            showMessageDialog(null, library.bookListToString(bList));
        });

        authorButton.addActionListener(e -> {
            final var bList = library.sortBy("author");
            showMessageDialog(null, library.bookListToString(bList));
        });

        yearButton.addActionListener(e -> {
            final var bList = library.sortBy("year");
            showMessageDialog(null, library.bookListToString(bList));
        });

        publisherButton.addActionListener(e -> {
            final var bList = library.sortBy("publisher");
            showMessageDialog(null, library.bookListToString(bList));
        });

        // Set the frame visible
        frame.setVisible(true);
    }

    public Library() {
        this.load_books();

    }

    private void load_books() {
        try {
            final Scanner s = new Scanner(new File("/home/adschoen/dev-studium/dhbw-exercise/src/main/java/de/dhbw/programming/secondsemester/datastructures/library/books.txt"));
            final List<String> contents = new ArrayList<>();
            while (s.hasNext()) {
                contents.add(s.nextLine());
            }
            s.close();
            this.books.clear();
            for (final String c : contents) {
                final List<String> splitC = List.of(c.split(";"));
                this.books.add(new Book(splitC.get(0), splitC.get(1), Integer.parseInt(splitC.get(2)), splitC.get(3)));
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private List<Book> sortBy(final String type) {
        final List<Book> sortedBooks = new ArrayList<>(this.books);

        switch (type) {
            case "title" -> sortedBooks.sort(Comparator.comparing(Book::getTitle));
            case "author" -> sortedBooks.sort(Comparator.comparing(Book::getAuthor));
            case "year" -> sortedBooks.sort(Comparator.comparing(Book::getYear));
            case "publisher" -> sortedBooks.sort(Comparator.comparing(Book::getPublisher));
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        }
        return sortedBooks;
    }

    private boolean doesStringExistInFile(final String searchString) {
        try (final BufferedReader br = new BufferedReader(new FileReader("/home/adschoen/dev-studium/dhbw-exercise/src/main/java/de/dhbw/programming/secondsemester/datastructures/library/books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String bookListToString(final List<Book> books) {
        var s = "";
        for (final Book book : books) {
            s = s + book.getTitle() + ";" + book.getAuthor() + ";" + book.getYear() + ";" + book.getPublisher() + "\n";
        }
        return s;
    }
}
