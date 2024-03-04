package de.dhbw.programming.exercise.io;


import java.io.IOException;
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

        Files.deleteIfExists(crossTotalFilePath);
        Files.deleteIfExists(crossTotalDirPath);

        Files.createDirectory(crossTotalDirPath);
        Files.createFile(crossTotalFilePath);

        Files.writeString(crossTotalFilePath, String.format("The cross total of %s is: %s%n", query, res));
    }
}
