package de.dhbw.programming.exercise.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileExperiments {
    public static void main(final String[] args) throws IOException {
        final var testDir = Path.of("testDir");
        final var filenames = Arrays.asList("foo1", "foo2", "foo3");

        // Delete files
        for (final var file : filenames) {
            Files.deleteIfExists(Path.of(testDir + "/" + file));
        }
        Files.deleteIfExists(testDir);

        try {
            Files.createDirectories(testDir);
            for (final var file : filenames) {
                final var filePath = testDir.resolve(file);
                Files.createFile(filePath);
            }
            System.out.printf("Absolute Path: {%s}%n", testDir.toAbsolutePath());
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
