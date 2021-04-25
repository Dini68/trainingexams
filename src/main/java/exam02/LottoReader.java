package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int num1 = Integer.parseInt(parts[11]);
                int num2 = Integer.parseInt(parts[12]);
                int num3 = Integer.parseInt(parts[13]);
                int num4 = Integer.parseInt(parts[14]);
                int num5 = Integer.parseInt(parts[15]);
                numbers[num1 - 1] ++;
                numbers[num2 - 1] ++;
                numbers[num3 - 1] ++;
                numbers[num4 - 1] ++;
                numbers[num5 - 1] ++;
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public int getNumber(int i) {
        return numbers[i - 1];
    }

}
