package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> owlsByCounty = new HashMap<>();

    public Map<String, Integer> getOwlsByCounty() {
        return owlsByCounty;
    }

    public void readFromFile(BufferedReader reader) {
            try  {
                String line;
                String county;
                int number = 0;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("=");
                    county = parts[0];
                    number = Integer.parseInt(parts[1]);
                    owlsByCounty.put(county, number);
                }
            } catch (
                    IOException ioe) {
                throw new IllegalStateException("Can not read file", ioe);
            }
        }

    public int getNumberOfOwls(String s) {
        return getOwlsByCounty().get(s);
    }
}
