package hu.nive.ujratervezes.zaropotpotvizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DaVinciCode {

    public int encode(String fileName, char ch) {
        if (ch != '1' && ch != '0' && ch != 'x') {
            throw new IllegalArgumentException("Wrong data");
        }
        int count = 0;
        Path path = Path.of(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c: line.toCharArray()) {
                    if (c == ch) {
                        count ++;
                    }
                }
                System.out.println(line);
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return count;
    }
}
