package hu.nive.ujratervezes.zaropotpotvizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> uniqueChars(String s) {
        List<Character> result = new ArrayList<>();
        if (s == null) {
            throw new IllegalArgumentException("Wrong data");
        }
        for (char ch: s.toCharArray()) {
            if (!result.contains(ch)) {
                result.add(ch);
            }
        }
        return result;
    }
}
