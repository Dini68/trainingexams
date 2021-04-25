package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class WorkHours {

    public String minWork(String file) {
        String result = "";
        Path path = Path.of(file);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            String name;
            int hours;
            LocalDate date;
            int minHours = 24;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                name = parts[0];
                hours = Integer.parseInt(parts[1]);
                date = LocalDate.parse(parts[2]);
                if (hours < minHours) {
                    minHours = hours;
                    result = name + ": " + date;
                }
            }
            return result;
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
