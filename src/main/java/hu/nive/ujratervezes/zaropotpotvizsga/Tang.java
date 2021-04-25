package hu.nive.ujratervezes.zaropotpotvizsga;

public class Tang extends Fish {

    public Tang(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        addWeight(1);
    }

    @Override
    public boolean hasMemoryLoss() {
        return true;
    }
}
