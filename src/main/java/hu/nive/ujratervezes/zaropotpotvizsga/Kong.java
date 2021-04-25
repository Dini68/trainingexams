package hu.nive.ujratervezes.zaropotpotvizsga;

public class Kong extends Fish {

    public Kong(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        addWeight(2);
    }

    @Override
    public boolean hasMemoryLoss() {
        return false;
    }
}
