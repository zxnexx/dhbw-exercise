package de.dhbw.programming.exercise.io;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CrossTotalFile {
    public static void main(final String[] args) throws IOException {
        final var scanner = new Scanner(System.in);

        System.out.print("Please enter int for cross total: ");
        final String query = scanner.next();
        var res = 0;

        final char[] numCharArray = query.toCharArray();
        for (final char c : numCharArray) {
            res += c - '0';  // idk
        }
        final var crossTotalDirPath = Path.of("CrossTotal");
        final var crossTotalFilePath = crossTotalDirPath.resolve("result.txt");

        try {
            Files.createDirectory(crossTotalDirPath);
            Files.createFile(crossTotalFilePath);
        } catch (final FileAlreadyExistsException ignored) {
        }

        final var bw = new BufferedWriter(new FileWriter(crossTotalFilePath.toFile(), true));
        bw.write(String.format("The cross total of %s is: %s", query, res));
        bw.newLine();
        bw.close();
    }
}
