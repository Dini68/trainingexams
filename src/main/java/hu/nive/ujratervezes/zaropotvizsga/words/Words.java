package hu.nive.ujratervezes.zaropotvizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int digitNum = 0;
        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitNum ++;
            }
        }
        return digitNum > s.length() - digitNum;
    }
}
