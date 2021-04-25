package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader reader) {
        List<String> result = new ArrayList<>();
        try  {
            String line;
            String station = "";
            int level;
            while ((line = reader.readLine()) != null) {
                if (line.contains("allomas")) {
                    station = line.split(":")[1];
                    station = station.substring(station.indexOf('"') + 1, station.lastIndexOf('"'));
                }
                if (line.contains("level")) {
                    level = Integer.parseInt(line.substring(line.indexOf(':') + 2, line.length()-1));
                    if (level > 2) {
                        result.add(station);
                    }
                }
            }
            Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
            return result;
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
