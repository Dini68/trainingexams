package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public static final char STAR_CHARACTER = '*';

    public String createHistogram(BufferedReader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                lineProcess(sb, line);
            }
            return sb.toString();
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void lineProcess(StringBuilder sb, String line) {
        int starNum = Integer.parseInt(line);
        for (int i = 0; i < starNum; i++) {
            sb.append(STAR_CHARACTER);
        }
        sb.append("\n");
    }
}
