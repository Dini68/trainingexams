package hu.nive.ujratervezes.zaropotvizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    private int numOfMales;

    public int getNumberOfMales(String fileName) {
        Path file = Path.of(fileName);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return numOfMales;
    }

    private void processLine(String line) {
        if (line.split(",")[4].equals("Male")) {
            numOfMales++;
        }
    }
}
