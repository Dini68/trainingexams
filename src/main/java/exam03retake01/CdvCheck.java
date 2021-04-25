package exam03retake01;

public class CdvCheck {

    public boolean check(String s) {
        if (s.length() != 10) {
            throw new IllegalArgumentException("No 10 digits");
        }
        int index = 0;
        int sum = 0;
        for (char ch: s.toCharArray()) {
            index ++;
            if (Character.isDigit(ch)) {
                if (index == 10) {
                    return sum % 11 == Character.getNumericValue(ch);
                }
                sum += index * Character.getNumericValue(ch);
            }
            else {
                throw new IllegalArgumentException("No digit");
            }
        }
        throw new IllegalArgumentException("Wrong data");
    }
}
